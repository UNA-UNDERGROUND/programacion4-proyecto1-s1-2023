package net.rnvn.db;

import java.sql.Connection;

public class PolizasDAO {
    protected Connection obtenerConexion() {
        return GestorConexion.obtenerInstancia().obtenerConexion();
    }
}
