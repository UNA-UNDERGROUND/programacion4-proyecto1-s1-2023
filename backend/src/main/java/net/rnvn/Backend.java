package net.rnvn;

import net.rnvn.controller.CredencialesController;
import net.rnvn.model.Credenciales;

import net.rnvn.controller.ClienteController;
import net.rnvn.model.Cliente;

public class Backend {
    public static void main(String[] args) {
        
        //Credenciales credenciales = new Credenciales("123", "123");
        Credenciales test = new Credenciales("123", "123");
        //boolean res = CredencialesController.getInstance().login(credenciales);
        CredencialesController.getInstance().delete(test);
        //boolean test1 = CredencialesController.getInstance().login(test);
        boolean res = ClienteController.getInstance().eliminarCliente("123");

        System.out.println(res);
    }
}
