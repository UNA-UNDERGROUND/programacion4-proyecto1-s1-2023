package net.rnvn.model.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.rnvn.db.PolizasDAO;
import net.rnvn.db.QueryGen;
import net.rnvn.model.Cobertura;

public class CoberturaDAO extends PolizasDAO{
    public CoberturaDAO() {
        super();
    }

    public boolean agregarCobertura(Cobertura cobertura) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_ADD_COBERTURA)) {

            stmt.clearParameters();
            stmt.setInt(1, cobertura.getId_cobertura());
            stmt.setInt(2, cobertura.getId_categoria());
            stmt.setString(3, cobertura.getNombre());
            stmt.setString(4, cobertura.getDescripcion());
            stmt.setBigDecimal(5, cobertura.getValor_minimo());
            stmt.setBigDecimal(6, cobertura.getValor_porcentage());
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al agregar cobertura: " + e.getMessage());
        }
        return result;
    }

    public Cobertura getCobertura(int id_cobertura) {
        Cobertura cobertura = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_GET_COBERTURA)) {
            stmt.clearParameters();
            stmt.setInt(1, id_cobertura);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id_categoria = rs.getInt("id_categoria");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    BigDecimal valor_minimo = rs.getBigDecimal("valor_minimo");
                    BigDecimal valor_porcentage = rs.getBigDecimal("valor_porcentage");
                    cobertura = new Cobertura(id_cobertura, id_categoria, nombre, descripcion, valor_minimo, valor_porcentage);
                }
            }
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al obtener cobertura: " + e.getMessage());
        }
        return cobertura;
    }

    public boolean actualizarCobertura(Cobertura cobertura) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_COBERTURA)) {
            stmt.clearParameters();
            stmt.setInt(1, cobertura.getId_categoria());
            stmt.setString(2, cobertura.getNombre());
            stmt.setString(3, cobertura.getDescripcion());
            stmt.setBigDecimal(4, cobertura.getValor_minimo());
            stmt.setBigDecimal(5, cobertura.getValor_porcentage());
            stmt.setInt(6, cobertura.getId_cobertura());
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al actualizar cobertura: " + e.getMessage());
        }
        return result;
    }

    public boolean eliminarCobertura(int id_cobertura) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_COBERTURA)) {
            stmt.clearParameters();
            stmt.setInt(1, id_cobertura);
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al eliminar cobertura: " + e.getMessage());
        }
        return result;
    }

    // consultas SQL

    private static final String TABLE_NAME = "cobertura";

    private static final String SQL_ADD_COBERTURA
        = QueryGen.genInsertInto(
            TABLE_NAME,
            new String[] {"id_cobertura", "id_categoria", "nombre", "descripcion", "valor_minimo", "valor_porcentage"});
    private static final String SQL_GET_COBERTURA
        = QueryGen.genSelectString(
            TABLE_NAME, 
            new String[] {"id_categoria", "nombre", "descripcion", "valor_minimo", "valor_porcentage"},
            new String[] {"id_cobertura = ?"});
    private static final String SQL_UPDATE_COBERTURA
        = QueryGen.genUpdateString(
            TABLE_NAME,
            new String[] {"id_categoria", "nombre", "descripcion", "valor_minimo", "valor_porcentage"},
            new String[] {"id_cobertura = ?"}); 
    private static final String SQL_DELETE_COBERTURA
        = QueryGen.genDeleteString(
            TABLE_NAME,
            new String[] {"id_cobertura = ?"});
}
