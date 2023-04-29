package net.rnvn.frontend.credenciales;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "GestorLogout", urlPatterns = { "/logout" })
public class GestorLogout extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // check that there is a session open
        HttpSession session = request.getSession();
        if (session.getAttribute("credenciales") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
