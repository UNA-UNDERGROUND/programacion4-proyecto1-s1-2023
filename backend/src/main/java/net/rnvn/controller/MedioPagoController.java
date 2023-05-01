package net.rnvn.controller;

import net.rnvn.model.MedioPago;
import net.rnvn.model.dao.MedioPagoDAO;

public class MedioPagoController {
    
    public boolean agregarMedioPago(MedioPago medioPago) {
        return medioPagoDAO.agregarMedioPago(medioPago);
    }

    public MedioPago getMedioPago(int idMedioPago) {
        return medioPagoDAO.getMedioPago(idMedioPago);
    }

    public boolean actualizarMedioPago(MedioPago medioPago) {
        return medioPagoDAO.actualizarMedioPago(medioPago);
    }

    public boolean eliminarMedioPago(int idMedioPago) {
        return medioPagoDAO.eliminarMedioPago(idMedioPago);
    }

    MedioPagoDAO medioPagoDAO = new MedioPagoDAO();

    //singleton 

    private static MedioPagoController instance;

    private MedioPagoController() {
    }

    public static MedioPagoController getInstance() {
        return instance == null ? instance = new MedioPagoController() : instance;
    }

}
