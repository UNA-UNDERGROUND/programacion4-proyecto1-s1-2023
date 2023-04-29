package net.rnvn.frontend.credenciales;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GestorLogout", urlPatterns = { "/logout" })
public class GestorLogout extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // check that there is a session open
        // if there is, close it
        // redirect to index.jsp
        if (request.getSession().getAttribute("credenciales") != null) {
            request.getSession().removeAttribute("credenciales");
        }
        // explicitly invalidate the session
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
