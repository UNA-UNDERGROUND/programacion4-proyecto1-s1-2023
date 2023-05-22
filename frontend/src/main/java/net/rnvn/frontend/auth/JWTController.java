package net.rnvn.frontend.auth;

import java.util.Map;
import java.util.Properties;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTController {

    private JWTController() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream(PROPERTIES_PATH));
            String publicKey = properties.getProperty("RSAKeyPublicPath");
            String privateKey = properties.getProperty("RSAPrivateKeyPath");
            algorithm = Algorithm.RSA256(publicKey, privateKey);
            verifier = JWT.require(algorithm)
                    .withIssuer(Issuer)
                    .build();

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
        long now = System.currentTimeMillis() / 1000L;
        builder.withIssuedAt(new java.util.Date(now));
        builder.withExpiresAt(new java.util.Date(now + ExpirationTime));

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
    private int ExpirationTime;

    private static String PROPERTIES_PATH = "/configuraciones/jwt.properties";

    // singleton
    private static JWTController instance;

    public static JWTController getInstance() {
        return instance == null ? instance = new JWTController() : instance;
    }

}
