package net.rnvn;

import net.rnvn.controller.CredencialesController;
import net.rnvn.model.Credenciales;

public class Backend {
    public static void main(String[] args) {
        Credenciales credenciales = new Credenciales("123", "123");
        boolean res = CredencialesController.getInstance().login(credenciales);
        System.out.println(res);
    }
}
