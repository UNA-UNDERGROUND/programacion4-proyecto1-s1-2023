package net.rnvn.controller;

import net.rnvn.model.Cliente;
import net.rnvn.model.dao.ClienteDAO;

public class ClienteController {

    public boolean agregarCliente(Cliente cliente) {
        return clienteDAO.agregarCliente(cliente);
    }

    public Cliente getCliente(String identificacion) {
        return clienteDAO.getCliente(identificacion);
    }

    public boolean actualizarCliente(Cliente cliente) {
        return clienteDAO.actualizarCliente(cliente);
    }

    public boolean eliminarCliente(String identificacion) {
        return clienteDAO.eliminarCliente(identificacion);
    }

    ClienteDAO clienteDAO = new ClienteDAO();

    // singleton
    private static ClienteController instance;

    private ClienteController() {
    }

    public static ClienteController getInstance() {
        return instance == null ? instance = new ClienteController() : instance;
    }
}
