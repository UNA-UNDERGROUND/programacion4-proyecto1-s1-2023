package net.rnvn.frontend.credenciales;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import net.rnvn.controller.ClienteController;
import net.rnvn.controller.CredencialesController;
import net.rnvn.model.Cliente;
import net.rnvn.model.Credenciales;

@WebServlet(name = "GestorCliente", urlPatterns = { "/GestorCliente", "updateCliente" })
public class GestorCliente extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("txtName");
        String lastName = request.getParameter("txtApellido");
        String telefono = request.getParameter("txtNumero");
        String nombrePropietario = request.getParameter("txtPropietario");
        String numTarjeta = request.getParameter("txtNumeroTarjeta");
        LocalDateTime fechaVencimiento = LocalDateTime.parse(request.getParameter("txtFecha"));
        String txtCVV = request.getParameter("txtCvv");

        
    }

    protected void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}