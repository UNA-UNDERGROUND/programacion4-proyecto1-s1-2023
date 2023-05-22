package net.rnvn.frontend.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.rnvn.controller.CredencialesController;
import net.rnvn.frontend.auth.JWTController;
import net.rnvn.model.Credenciales;

@WebServlet(name = "LoginController", urlPatterns = { "/api/login" })
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (BufferedReader reader = request.getReader()) {
            CredencialesController controller = CredencialesController.getInstance();
            Credenciales credenciales = new Gson().fromJson(reader, Credenciales.class);
            if (controller.login(credenciales)) {
                JWTController jwtController = JWTController.getInstance();
                Map<String, String> claims = new HashMap<>();
                // set the user id as the subject
                claims.put("sub", credenciales.getIdentificacion());
                String token = jwtController.getJWTToken(claims);
                response.setStatus(HttpServletResponse.SC_OK);
                // send the token in the response body
                response.getWriter().write(token);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (Exception e) {
            System.err.println(this.getClass().getName() + ": " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
