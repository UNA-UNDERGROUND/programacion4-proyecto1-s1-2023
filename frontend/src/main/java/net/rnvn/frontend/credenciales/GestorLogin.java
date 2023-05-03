package net.rnvn.frontend.credenciales;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rnvn.controller.ClienteController;
import net.rnvn.controller.CredencialesController;
import net.rnvn.model.Cliente;
import net.rnvn.model.Credenciales;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "GestorLogin", urlPatterns = { "/login" })
public class GestorLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Credenciales credenciales = validarCredenciales(request);
        if (CredencialesController.getInstance().login(credenciales)) {
            // tambien debe existir un cliente con ese username
            Cliente cliente = ClienteController.getInstance().getCliente(credenciales.getIdentificacion());
            if (cliente != null) {
                request.getSession().setAttribute("credenciales", credenciales);
                request.getSession().setAttribute("cliente", cliente);
                response.sendRedirect(request.getContextPath() + "/principalClient.jsp");
            }
        }
        else{
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    // verifica que se puedan crear credenciales con los parametros y las retorna
    private Credenciales validarCredenciales(HttpServletRequest request) {
        // verificamos que sea POST
        Credenciales credenciales = null;
        if (request.getMethod().equals("POST")) {
            Map<String, String[]> parametros = request.getParameterMap();
            if (parametros.containsKey("username") && parametros.containsKey("password")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                credenciales = new Credenciales(username, password);
            }
        }
        return credenciales;
    }
}
