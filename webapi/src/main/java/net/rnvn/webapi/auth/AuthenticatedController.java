package net.rnvn.webapi.auth;

import java.io.IOException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.rnvn.webapi.util.RestController;

// Esta clase esta pensada para que que todo controlador que requiere autenticacion herede de ella
public class AuthenticatedController extends RestController {

    // abstract methods [onGet, onPost]

    protected void onGet(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject,
            DecodedJWT decodedJWT)
            throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onPost(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject,
            DecodedJWT decodedJWT)
            throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onPut(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject,
            DecodedJWT decodedJWT)
            throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onDelete(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject,
            DecodedJWT decodedJWT)
            throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    // override rest controller methods
    @Override
    protected void onGet(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject json)
            throws ServletException, IOException {
        handleAuthentication(req, resp, json, (request, response, jsonObject, decodedJWT) -> {
            try {
                onGet(request, response, jsonObject, decodedJWT);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        });
    }

    @Override
    protected void onPost(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject json)
            throws ServletException, IOException {
        handleAuthentication(req, resp, json, (request, response, jsonObject, decodedJWT) -> {
            try {
                onPost(req, resp, json, decodedJWT);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        });
    }

    @Override
    protected void onPut(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject json)
            throws ServletException, IOException {
        handleAuthentication(req, resp, json, (request, response, jsonObject, decodedJWT) -> {
            try {
                onPut(req, resp, json, decodedJWT);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        });
    }

    @Override
    protected void onDelete(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject json)
            throws ServletException, IOException {
        handleAuthentication(req, resp, json, (request, response, jsonObject, decodedJWT) -> {
            try {
                onDelete(req, resp, json, decodedJWT);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        });
    }

    private void handleAuthentication(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject,
            // callback(request, response, jsonObject, decodedJWT)
            HTTPCallback callback)
            throws jakarta.servlet.ServletException, java.io.IOException {

        try {
            // get the token from the request header
            String token = req.getHeader("Authorization");
            // remove the header prefix
            if (null != token && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            // check if the token is valid
            DecodedJWT decodedJWT = getDecodedJWT(token);
            if (null != decodedJWT) {
                // 200 OK
                callback.onVerified(req, resp, jsonObject, decodedJWT);
                return;
            }
        } catch (Exception e) {
            System.err.println(this.getClass().getName() + ": " + e.getMessage());
        }
        // 401 Unauthorized
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    private DecodedJWT getDecodedJWT(String token) {
        // check if the token is valid
        if (null == token) {
            return null;
        }
        JWTController jwtController = JWTController.getInstance();
        return jwtController.verifyJWTToken(token);
    }

    @FunctionalInterface
    public interface HTTPCallback {
        public void onVerified(HttpServletRequest t, HttpServletResponse u, JsonObject o, DecodedJWT v);
    }

}
