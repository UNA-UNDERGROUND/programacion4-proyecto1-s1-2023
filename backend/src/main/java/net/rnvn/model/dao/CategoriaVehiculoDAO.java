package net.rnvn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.rnvn.db.PolizasDAO;
import net.rnvn.db.QueryGen;
import net.rnvn.model.CategoriaVehiculo;

public class CategoriaVehiculoDAO extends PolizasDAO {
    public CategoriaVehiculoDAO() {
        super();
    }

    public boolean agregarCategoriaVehiculo(CategoriaVehiculo categoriaVehiculo) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_ADD_CATEGORIA_VEHICULO_STRING)) {

            stmt.clearParameters();
            stmt.setInt(1, categoriaVehiculo.getIdCategoriaVehiculo());
            stmt.setString(2, categoriaVehiculo.getMarca());
            stmt.setString(3, categoriaVehiculo.getModelo());
            stmt.setInt(4, categoriaVehiculo.getSerie());
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al agregar categoria vehiculo: " + e.getMessage());
        }
        return result;
    }

    public CategoriaVehiculo getCategoriaVehiculo(int idCategoriaVehiculo) {
        CategoriaVehiculo categoriaVehiculo = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_GET_CATEGORIA_VEHICULO)) {
            stmt.clearParameters();
            stmt.setInt(1, idCategoriaVehiculo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String marca = rs.getString("marca");
                    String modelo = rs.getString("modelo");
                    int serie = rs.getInt("serie");
                    categoriaVehiculo = new CategoriaVehiculo(idCategoriaVehiculo, marca, modelo, serie);
                }
            }
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al obtener categoria vehiculo: " + e.getMessage());
        }
        return categoriaVehiculo;
    }

    public boolean actualizarCategoriaVehiculo(CategoriaVehiculo categoriaVehiculo) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_CATEGORIA_VEHICULO)) {
            stmt.clearParameters();
            stmt.setInt(1, categoriaVehiculo.getIdCategoriaVehiculo());
            stmt.setString(2, categoriaVehiculo.getMarca());
            stmt.setString(3, categoriaVehiculo.getModelo());
            stmt.setInt(4, categoriaVehiculo.getSerie());
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al actualizar categoria vehiculo: " + e.getMessage());
        }
        return result;
    }

    public boolean eliminarCategoriaVehiculo(int idCategoriaVehiculo) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_CATEGORIA_VEHICULO)) {
            stmt.clearParameters();
            stmt.setInt(1, idCategoriaVehiculo);
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al eliminar categoria vehiculo: " + e.getMessage());
        }
        return result;
    }

    // consultas SQL

    private static final String TABLE_NAME = "categoria_vehiculo";

    private static final String SQL_ADD_CATEGORIA_VEHICULO_STRING = QueryGen.genInsertInto(
            TABLE_NAME,
            new String[] { "id_categoria_vehiculo", "marca", "modelo", "serie" });
    private static final String SQL_GET_CATEGORIA_VEHICULO = QueryGen.genSelectString(
            TABLE_NAME,
            new String[] { "marca", "modelo", "serie" },
            new String[] { "id_categoria_vehiculo = ?" });
    private static final String SQL_UPDATE_CATEGORIA_VEHICULO = QueryGen.genUpdateString(
            TABLE_NAME,
            new String[] { "marca", "modelo", "serie" },
            new String[] { "id_categoria_vehiculo = ?" });
    private static final String SQL_DELETE_CATEGORIA_VEHICULO = QueryGen.genDeleteString(
            TABLE_NAME,
            new String[] { "id_categoria_vehiculo = ?" });
}
