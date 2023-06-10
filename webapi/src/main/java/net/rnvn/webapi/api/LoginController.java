package net.rnvn.webapi.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.rnvn.controller.CredencialesController;
import net.rnvn.webapi.auth.JWTController;
import net.rnvn.webapi.util.RestController;
import net.rnvn.model.Credenciales;

@WebServlet(name = "LoginController", urlPatterns = { "/api/login" })
public class LoginController extends RestController {

    private class JSONToken {
        @SuppressWarnings("unused")
        public String token;

        public JSONToken(String token) {
            this.token = token;
        }
    }

    @Override
    protected void onPost(
            HttpServletRequest req,
            HttpServletResponse resp,
            JsonObject jsonObject)
            throws ServletException, IOException {
        Credenciales credenciales = new Gson().fromJson(jsonObject, Credenciales.class);
        if (null != credenciales) {
            CredencialesController controller = CredencialesController.getInstance();
            if (controller.login(credenciales)) {
                JWTController jwtController = JWTController.getInstance();
                Map<String, String> claims = new HashMap<>();
                // set the user id as the subject
                claims.put("sub", credenciales.getIdentificacion());
                String token = jwtController.getJWTToken(claims);
                writeResponse(resp, new JSONToken(token));
            } else {
                writeResponse(resp, HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            writeResponse(resp, HttpServletResponse.SC_BAD_REQUEST);
        }

    }

}
