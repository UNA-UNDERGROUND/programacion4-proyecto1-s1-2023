package net.rnvn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.rnvn.db.PolizasDAO;
import net.rnvn.db.QueryGen;
import net.rnvn.model.Credenciales;

public class CredencialesDAO extends PolizasDAO {

    public CredencialesDAO() {
        super();
    }

    public boolean agregarCredenciales(Credenciales credenciales) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_ADD_CREDENCIALES)) {
            stmt.setString(1, credenciales.getIdentificacion());
            stmt.setString(2, credenciales.getPassword());
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al agregar credenciales: " + e.getMessage());
        }
        return result;
    }

    public Credenciales getCredenciales(String identificacion) {
        Credenciales credenciales = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_GET_CREDENCIALES)) {
            stmt.clearParameters();
            stmt.setString(1, identificacion);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String password = rs.getString("password");
                    credenciales = new Credenciales(identificacion, password);
                }
            }
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al obtener credenciales: " + e.getMessage());
        }
        return credenciales;
    }

    public boolean actualizarCredenciales(Credenciales credenciales) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_CREDENCIALES)) {
            stmt.clearParameters();
            stmt.setString(1, credenciales.getPassword());
            stmt.setString(2, credenciales.getIdentificacion());
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al actualizar credenciales: " + e.getMessage());
        }
        return result;
    }

    public boolean eliminarCredenciales(String identificacion) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_CREDENCIALES)) {
            stmt.clearParameters();
            stmt.setString(1, identificacion);
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al eliminar credenciales: " + e.getMessage());
        }
        return result;
    }

    // consultas SQL

    private static final String TABLE_NAME = "credenciales";

    private static final String SQL_ADD_CREDENCIALES //
            = QueryGen.genInsertInto(
                    "credenciales",
                    new String[] { "identificacion", "password" });

    private static final String SQL_GET_CREDENCIALES //
            = QueryGen.genSelectString(
                    TABLE_NAME,
                    new String[] { "identificacion", "password" },
                    new String[] { "identificacion = ?" });

    private static final String SQL_UPDATE_CREDENCIALES //
            = QueryGen.genUpdateString(
                    TABLE_NAME,
                    new String[] { "password" },
                    new String[] { "identificacion = ?" });

    private static final String SQL_DELETE_CREDENCIALES //
            = QueryGen.genDeleteString(
                    TABLE_NAME,
                    new String[] { "identificacion = ?" });

}
