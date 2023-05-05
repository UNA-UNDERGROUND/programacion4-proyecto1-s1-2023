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
import net.rnvn.model.Credenciales;
import net.rnvn.model.MedioPago;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "GestorRegistro", urlPatterns = { "/GestorRegistro", "register" })
public class GestorRegistro extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
                if (!validarUsuarioRepetido(request)){
                String userID = request.getParameter("txtIdentificador");
                String password = request.getParameter("txtPassword");
                String email = request.getParameter("txtEmail");
                String nombre = request.getParameter("txtName");
                String apellido = request.getParameter("txtApellido");
                String telefono = request.getParameter("txtNumero");
                
                int numeroTarjeta = Integer.parseInt(request.getParameter("txtNumeroTarjeta"));
                String propietario = request.getParameter("txtPropietario");
                String fechaVencimiento = request.getParameter("txtFecha");
                String cvv = request.getParameter("txtCvv");

                try{
                //Datos de credenciales del cliente
                Credenciales credencial = new Credenciales(userID, password);
                CredencialesController.getInstance().registerCredentials(credencial);
                //Datos del cliente
                Cliente user = new Cliente(userID, nombre, apellido, telefono, email);
                ClienteController.getInstance().agregarCliente(user);
                //Datos de medio de pago del cliente
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                LocalDateTime dateTime = LocalDateTime.parse(fechaVencimiento, formatter);
                
                MedioPago medioPago = new MedioPago(0, userID, numeroTarjeta, propietario, dateTime, cvv);
                MedioPagoController.getInstance().agregarMedioPago(medioPago);

                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.println("<script type='text/javascript'>");
                out.println("alert('Usuario creado');");
                out.println("window.open('" + request.getContextPath() + "/index.jsp');");
                out.println("</script>");

                } catch (Exception e){
                    PrintWriter out = response.getWriter();
                    response.setContentType("text/html");
                    out.println("<script type='text/javascript'>");
                    out.println("alert('Error al crear usuario');");
                    out.println("window.open('" + request.getContextPath() + "/index.jsp');");
                    out.println("</script>");
                }

                }else{
                    PrintWriter out = response.getWriter();
                    response.setContentType("text/html");
                    out.println("<script type='text/javascript'>");
                    out.println("alert('Usuario repetido por identificación');");
                    out.println("window.open('" + request.getContextPath() + "/index.jsp');");
                    out.println("</script>");
                }
            }    


    // verifica si el usuario esta repetido con un mismo identificador
    private boolean validarUsuarioRepetido(HttpServletRequest request) {
        boolean repetido = false;
        // verificamos que sea POST
        if (request.getMethod().equals("POST")) {
            Map<String, String[]> parametros = request.getParameterMap();
            if (parametros.containsKey("txtIdentificador")) {
                Cliente cliente = null;
                cliente = ClienteController.getInstance().getCliente(request.getParameter("txtIdentificador"));
                if (cliente != null)
                    repetido = true;
            }
        }
        return repetido;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(req, resp);
    }
}
