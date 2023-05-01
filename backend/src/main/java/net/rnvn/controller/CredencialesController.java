package net.rnvn.controller;

import net.rnvn.model.Cliente;
import net.rnvn.model.Credenciales;
import net.rnvn.model.dao.ClienteDAO;
import net.rnvn.model.dao.CredencialesDAO;

public class CredencialesController {

    // login
    public boolean login(Credenciales credenciales) {
        return credenciales.equals(credencialesDAO.getCredenciales(credenciales.getIdentificacion()));
    }

    // register

    public boolean registerCredentials(Credenciales credenciales) {
        return credencialesDAO.agregarCredenciales(credenciales);
    }

    public boolean registerUser(Cliente cliente, Credenciales credenciales) {
        return clienteDAO.registrarUsuario(cliente, credenciales.getPassword());
    }

    // update

    public boolean update(Credenciales credenciales) {
        return credencialesDAO.actualizarCredenciales(credenciales);
    }

    // delete

    public boolean delete(Credenciales credenciales) {
        return credencialesDAO.eliminarCredenciales(credenciales.getIdentificacion());
    }

    // DAO

    CredencialesDAO credencialesDAO = new CredencialesDAO();
    ClienteDAO clienteDAO = new ClienteDAO();

    // Singleton
    private CredencialesController() {
    }

    private static CredencialesController INSTANCE = null;

    public static CredencialesController getInstance() {
        return (INSTANCE == null) ? INSTANCE = new CredencialesController() : INSTANCE;
    }
}
