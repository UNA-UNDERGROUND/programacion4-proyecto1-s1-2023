package net.rnvn.db;

import java.sql.Connection;

public class PolizasDAO {
    protected Connection getConnection() {
        return GestorConexion.obtenerInstancia().obtenerConexion();
    }
}
