package net.rnvn.frontend.credenciales;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.rnvn.controller.ClienteController;
import net.rnvn.controller.CredencialesController;
import net.rnvn.model.Cliente;
import net.rnvn.model.Credenciales;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "GestorLogin", urlPatterns = { "/GestorLogin", "login" })
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
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type='text/javascript'>");
            out.println("alert('Usuario no existe');");
            out.println("window.open('" + request.getContextPath() + "/index.jsp');");
            out.println("</script>");
        }
    }

    // verifica que se puedan crear credenciales con los parametros y las retorna
    private Credenciales validarCredenciales(HttpServletRequest request) {
        // verificamos que sea GET
        Credenciales credenciales = null;
        if (request.getMethod().equals("GET")) {
            Map<String, String[]> parametros = request.getParameterMap();
            if (parametros.containsKey("username") && parametros.containsKey("password")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                credenciales = new Credenciales(username, password);
            }
        }
        return credenciales;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
