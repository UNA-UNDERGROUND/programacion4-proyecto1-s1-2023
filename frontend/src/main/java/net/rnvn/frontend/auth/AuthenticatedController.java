package net.rnvn.frontend.auth;

import java.io.IOException;
import com.auth0.jwt.interfaces.DecodedJWT;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Esta clase esta pensada para que que todo controlador que requiere autenticacion herede de ella
public class AuthenticatedController extends HttpServlet {

    // abstract methods [onGet, onPost]

    protected void onGet(
            HttpServletRequest req,
            HttpServletResponse resp,
            DecodedJWT decodedJWT)
            throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onPost(
            HttpServletRequest req,
            HttpServletResponse resp,
            DecodedJWT decodedJWT)
            throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onPut(
            HttpServletRequest req,
            HttpServletResponse resp,
            DecodedJWT decodedJWT)
            throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void onDelete(
            HttpServletRequest req,
            HttpServletResponse resp,
            DecodedJWT decodedJWT)
            throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @Override
    protected void doGet(
            jakarta.servlet.http.HttpServletRequest req,
            jakarta.servlet.http.HttpServletResponse resp)
            throws jakarta.servlet.ServletException, java.io.IOException {
        handleAuthentication(req, resp, (request, response, decodedJWT) -> {
            try {
                onGet(request, response, decodedJWT);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        });
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        handleAuthentication(req, resp, (request, response, decodedJWT) -> {
            try {
                onPost(request, response, decodedJWT);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        });
    }

    @Override
    protected void doPut(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        handleAuthentication(req, resp, (request, response, decodedJWT) -> {
            try {
                onPut(request, response, decodedJWT);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        });
    }

    @Override
    protected void doDelete(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        handleAuthentication(req, resp, (request, response, decodedJWT) -> {
            try {
                onDelete(request, response, decodedJWT);
            } catch (Exception e) {
                System.err.println(this.getClass().getName() + ": " + e.getMessage());
            }
        });
    }

    private void handleAuthentication(
            HttpServletRequest req,
            HttpServletResponse resp,
            // callback(request, response, decodedJWT)
            HTTPCallback callback)
            throws jakarta.servlet.ServletException, java.io.IOException {

        try {
            // get the token from the request header
            String token = req.getHeader("Authorization");
            // check if the token is valid
            DecodedJWT decodedJWT = getDecodedJWT(token);
            if (null != decodedJWT) {
                // 200 OK
                callback.onVerified(req, resp, decodedJWT);
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
        public void onVerified(HttpServletRequest t, HttpServletResponse u, DecodedJWT v);
    }

}
