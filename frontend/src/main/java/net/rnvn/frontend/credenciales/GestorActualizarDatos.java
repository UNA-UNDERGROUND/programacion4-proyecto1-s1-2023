package net.rnvn.frontend.credenciales;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.rnvn.controller.ClienteController;
import net.rnvn.controller.CredencialesController;
import net.rnvn.controller.MedioPagoController;
import net.rnvn.model.Cliente;
import net.rnvn.model.dao.ClienteDAO;
import net.rnvn.model.Credenciales;
import net.rnvn.model.MedioPago;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "GestorActualizarDatos", urlPatterns = { "/GestorActualizarDatos", "actualizarDatos" })
public class GestorActualizarDatos extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


         Credenciales credenciales = validarCredenciales(request);

         Cliente cliente = actualizarCliente(request);
        
        if (cliente != null) {
            ClienteController.getInstance().actualizarCliente(cliente);
            request.getSession().setAttribute("cliente", cliente);
        }

     /*   Credenciales credenciales = actualizar(request);
        if (credenciales != null) {
            CredencialesController.getInstance().actualizar(credenciales);
            request.getSession().setAttribute("credenciales", credenciales);
        }

        MedioPago medioPago = actualizar(request);
        if (medioPago != null) {
            MedioPagoController.getInstance().actualizar(medioPago);
            request.getSession().setAttribute("medioPago", medioPago);
        }
*/
        response.sendRedirect(request.getContextPath() + "/ActualizarRegistro.jsp");
    }
         //- Credenciales credencial = new Credenciales(userID, password);
           //-     CredencialesController.getInstance().registerCredentials(credencial);
        // if (CredencialesController.getInstance().login(credenciales)) {
        //     // tambien debe existir un cliente con ese username
        //     Cliente cliente = ClienteController.getInstance().getCliente(credenciales.getIdentificacion());
        //     if (cliente != null) {
        //         request.getSession().setAttribute("credenciales", credenciales);
        //         request.getSession().setAttribute("cliente", cliente);
        //         response.sendRedirect(request.getContextPath() + "/principalClient.jsp");
        //     }
        // }
        // else{
        //     PrintWriter out = response.getWriter();
        //     response.setContentType("text/html");
        //     out.println("<script type='text/javascript'>");
        //     out.println("alert('Usuario no existe');");
        //     out.println("window.open('" + request.getContextPath() + "/index.jsp');");
        //     out.println("</script>");
        // }

        // -> Metodo logico para actualizar datos de los clientes (Cliente, Credenciales, Metodo de pago)
    //}

    // verifica que se puedan actualizar los clientes y las retorna
    private Cliente actualizarCliente(HttpServletRequest request) {
    Cliente cliente = null;
    if (request.getMethod().equals("POST")) {
        Map<String, String[]> parametros = request.getParameterMap();
        if (parametros.containsKey("identificacion") && parametros.containsKey("nombre") &&
            parametros.containsKey("apellidos") && parametros.containsKey("telefono") &&
            parametros.containsKey("correo")) {

            String identificacion = request.getParameter("identificacion");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");

            cliente = new Cliente(identificacion, nombre, apellidos, telefono, correo);
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.actualizarCliente(cliente);
        }
    }
    return cliente;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(req, resp);
    }
}
