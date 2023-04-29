package net.rnvn.controller;

import net.rnvn.model.Credenciales;
import net.rnvn.model.dao.CredencialesDAO;

public class CredencialesController {

    // login
    public boolean login(Credenciales credenciales) {
        return credenciales.equals(credencialesDAO.getCredenciales(credenciales.getIdentificacion()));
    }

    // register

    public boolean register(Credenciales credenciales) {
        return credencialesDAO.agregarCredenciales(credenciales);
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

    // Singleton
    private CredencialesController() {
    }

    private static CredencialesController INSTANCE = null;

    public static CredencialesController getInstance() {
        return (INSTANCE == null) ? INSTANCE = new CredencialesController() : INSTANCE;
    }
}
