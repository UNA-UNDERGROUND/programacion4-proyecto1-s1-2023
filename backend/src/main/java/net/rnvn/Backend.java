package net.rnvn;

import net.rnvn.controller.CredencialesController;
import net.rnvn.model.Cliente;
import net.rnvn.model.Credenciales;

import net.rnvn.controller.ClienteController;

public class Backend {
    public static void main(String[] args) {
        //usuario prueba
        Credenciales test = new Credenciales("764", "admin2");
        CredencialesController.getInstance().registerCredentials(test);
        Cliente user = new Cliente("764", "Jose", "Lopez", "8238394", "alopez@gmail.com");
        boolean res = ClienteController.getInstance().agregarCliente(user);

        System.out.println(res);
    }
}
