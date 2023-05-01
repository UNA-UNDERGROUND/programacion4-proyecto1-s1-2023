package net.rnvn.controller;

import net.rnvn.model.PolizaVehiculo;
import net.rnvn.model.dao.PolizaVehiculoDAO;

public class PolizaVehiculoController {
    
    public boolean agregarPolizaVehiculo(PolizaVehiculo polizaVehiculo) {
        return polizaVehiculoDAO.agregarPolizaVehiculo(polizaVehiculo);
    }

    public PolizaVehiculo getPolizaVehiculo(int idPolizaVehiculo) {
        return polizaVehiculoDAO.getPolizaVehiculo(idPolizaVehiculo);
    }

    public boolean actualizarPolizaVehiculo(PolizaVehiculo polizaVehiculo) {
        return polizaVehiculoDAO.actualizarPolizaVehiculo(polizaVehiculo);
    }

    public boolean eliminarPolizaVehiculo(int idPolizaVehiculo) {
        return polizaVehiculoDAO.eliminarPolizaVehiculo(idPolizaVehiculo);
    }

    PolizaVehiculoDAO polizaVehiculoDAO = new PolizaVehiculoDAO();

    //singleton 

    private static PolizaVehiculoController instance;

    private PolizaVehiculoController() {
    }

    public static PolizaVehiculoController getInstance() {
        return instance == null ? instance = new PolizaVehiculoController() : instance;
    }
}
