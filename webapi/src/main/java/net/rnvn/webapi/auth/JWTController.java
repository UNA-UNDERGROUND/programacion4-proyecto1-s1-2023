package net.rnvn.webapi.auth;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;
import java.util.Properties;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTController {

    private JWTController() {

        try {

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream(PROPERTIES_PATH));
            String publicKeyPath = properties.getProperty("RSAKeyPublicPath");
            String privateKeyPath = properties.getProperty("RSAPrivateKeyPath");
            expirationTime = properties.getProperty("expirationTime") == null ? 3600
                    : Integer.parseInt(properties.getProperty("expirationTime"));
            // check if the files exist
            if (!Files.exists(Paths.get(publicKeyPath)) || !Files.exists(Paths.get(privateKeyPath))) {
                // generate the certificates
                generateCertificates(publicKeyPath, privateKeyPath);
            }

            // use bouncy castle to read the pem files
            try (FileReader publicKeyReader = new FileReader(new File(publicKeyPath));
                    FileReader privateKeyReader = new FileReader(new File(privateKeyPath));
                    PemReader publicPemReader = new PemReader(publicKeyReader);
                    PemReader privatePemReader = new PemReader(privateKeyReader)) {
                PemObject publicKeyObject = publicPemReader.readPemObject();
                PemObject privateKeyObject = privatePemReader.readPemObject();
                byte[] publicKeyBytes = publicKeyObject.getContent();
                byte[] privateKeyBytes = privateKeyObject.getContent();
                X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
                PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);

                RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
                RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
                algorithm = Algorithm.RSA256(pubKey, privKey);
                verifier = JWT.require(algorithm)
                        .withIssuer(Issuer)
                        .build();
            }

        } catch (Exception e) {
            System.err.println(this.getClass().getName() + ": " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public String getJWTToken(Map<String, String> claims) {
        Builder builder = JWT.create().withIssuer(Issuer);
        claims.forEach((key, value) -> {
            builder.withClaim(key, value);
        });
        // get the current timestamp in seconds
        Instant now = Instant.now();
        builder.withIssuedAt(now);
        builder.withExpiresAt(now.plusSeconds(expirationTime));

        return builder.sign(algorithm);
    }

    // decodes and verifies the token
    public DecodedJWT verifyJWTToken(String token) {
        return verifier.verify(token);
    }

    Algorithm algorithm;
    JWTVerifier verifier;

    private String Issuer = "UNA-P4";
    // expiration time in seconds
    private int expirationTime;

    private static String PROPERTIES_PATH = "/configuraciones/jwt.properties";

    // util methods

    private void generateCertificates(String publicPath, String privatePath) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        // try to open a file stream to both files
        try (BufferedWriter publicWriter = new BufferedWriter(new FileWriter(publicPath));
                BufferedWriter privateWriter = new BufferedWriter(new FileWriter(privatePath))) {
            // write the public key
            publicWriter.write("-----BEGIN PUBLIC KEY-----");
            publicWriter.newLine();
            publicWriter.write(Base64.getEncoder().encodeToString(kp.getPublic().getEncoded()));
            publicWriter.newLine();
            publicWriter.write("-----END PUBLIC KEY-----");
            publicWriter.newLine();
            // write the private key
            privateWriter.write("-----BEGIN PRIVATE KEY-----");
            privateWriter.newLine();
            privateWriter.write(Base64.getEncoder().encodeToString(kp.getPrivate().getEncoded()));
            privateWriter.newLine();
            privateWriter.write("-----END PRIVATE KEY-----");
            privateWriter.newLine();
        }

    }

    // singleton
    private static JWTController instance;

    public static JWTController getInstance() {
        return instance == null ? instance = new JWTController() : instance;
    }

}
