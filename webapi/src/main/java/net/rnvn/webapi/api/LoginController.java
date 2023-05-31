package net.rnvn.webapi.api;

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
import net.rnvn.webapi.auth.JWTController;
import net.rnvn.model.Credenciales;

@WebServlet(name = "LoginController", urlPatterns = { "/api/login" })
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (BufferedReader reader = request.getReader()) {
            CredencialesController controller = CredencialesController.getInstance();
            Credenciales credenciales = new Gson().fromJson(reader, Credenciales.class);
            if (null != credenciales) {
                if (controller.login(credenciales)) {
                    JWTController jwtController = JWTController.getInstance();
                    Map<String, String> claims = new HashMap<>();
                    // set the user id as the subject
                    claims.put("sub", credenciales.getIdentificacion());
                    String token = jwtController.getJWTToken(claims);
                    response.setStatus(HttpServletResponse.SC_OK);
                    // send the token in the response body
                    HashMap<String, String> map = new HashMap<>();
                    map.put("token", token);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(new Gson().toJson(map));
                    return;
                }
            }

        } catch (Exception e) {
            System.err.println(this.getClass().getName() + ": " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
