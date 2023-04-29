package net.rnvn.frontend.credenciales;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rnvn.controller.CredencialesController;
import net.rnvn.model.Credenciales;

import java.io.IOException;

@WebServlet(name = "GestorLogin", urlPatterns = { "/login" })
public class GestorLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        if (!request.getMethod().equals("POST")) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            // check that the parameters exist
            if (!request.getParameterMap().containsKey("username")
                    || !request.getParameterMap().containsKey("password")) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                // check that there is not a session already open
                if (request.getSession().getAttribute("credenciales") != null) {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                } else {
                    // check that the credentials are correct
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    Credenciales credenciales = new Credenciales(username, password);
                    if (CredencialesController.getInstance().login(credenciales)) {
                        request.getSession().setAttribute("credenciales", credenciales);
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                    }
                }
            }
        }

    }
}
