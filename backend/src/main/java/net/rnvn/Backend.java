package net.rnvn;

import net.rnvn.controller.CredencialesController;
import net.rnvn.model.Cliente;
import net.rnvn.model.Credenciales;

import net.rnvn.controller.ClienteController;

public class Backend {
    public static void main(String[] args) {
        //usuario prueba
        Credenciales test = new Credenciales("12345", "admin");
        CredencialesController.getInstance().registerCredentials(test);
        Cliente user = new Cliente("12345", "Alex", "Ramirez", "85095225", "alexram999rc@gmail.com");
        boolean res = ClienteController.getInstance().agregarCliente(user);

        System.out.println(res);
    }
}
