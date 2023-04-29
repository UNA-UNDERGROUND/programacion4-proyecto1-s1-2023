package net.rnvn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.rnvn.db.PolizasDAO;
import net.rnvn.db.QueryGen;
import net.rnvn.model.CategoriaCobertura;

public class CategoriaCoberturaDAO extends PolizasDAO {

    public CategoriaCoberturaDAO() {
        super();
    }

    public CategoriaCobertura agregarCategoriaCobertura(CategoriaCobertura categoriaCobertura) {
        CategoriaCobertura result = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_ADD_CATEGORIA_COBERTURA)) {

            stmt.clearParameters();
            stmt.setString(1, categoriaCobertura.getNombre());
            stmt.setString(2, categoriaCobertura.getDescripcion());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idCategoria = rs.getInt(1);
                        result = new CategoriaCobertura(idCategoria, categoriaCobertura.getNombre(),
                                categoriaCobertura.getDescripcion());
                    }
                }
            }
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al agregar categoria cobertura: " + e.getMessage());
        }
        return result;
    }

    public CategoriaCobertura getCategoriaCobertura(int idCategoria) {
        CategoriaCobertura categoriaCobertura = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_GET_CATEGORIA_COBERTURA)) {
            stmt.clearParameters();
            stmt.setInt(1, idCategoria);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    categoriaCobertura = new CategoriaCobertura(idCategoria, nombre, descripcion);
                }
            }
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al obtener categoria cobertura: " + e.getMessage());
        }
        return categoriaCobertura;
    }

    public boolean actualizarCategoriaCobertura(CategoriaCobertura categoriaCobertura) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_CATEGORIA_COBERTURA)) {
            stmt.clearParameters();
            stmt.setString(1, categoriaCobertura.getNombre());
            stmt.setString(2, categoriaCobertura.getDescripcion());
            stmt.setInt(3, categoriaCobertura.getIdCategoria());
            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al actualizar categoria cobertura: " + e.getMessage());
        }
        return result;
    }

    public boolean eliminarCategoriaCobertura(int idCategoria) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_CATEGORIA_COBERTURA)) {
            stmt.clearParameters();
            stmt.setInt(1, idCategoria);
            int rows = stmt.executeUpdate();
            result = rows > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al eliminar categoria cobertura: " + e.getMessage());
        }
        return result;
    }

    // consultas SQL

    private static final String TABLE_NAME = "categoria_cobertura";

    private static final String SQL_ADD_CATEGORIA_COBERTURA //
            = QueryGen.genInsertInto(
                    TABLE_NAME,
                    new String[] { "nombre", "descripcion" });
    private static final String SQL_GET_CATEGORIA_COBERTURA //
            = QueryGen.genSelectString(
                    TABLE_NAME,
                    new String[] { "id_categoria", "nombre", "descripcion" },
                    new String[] { "id_categoria = ?" });
    private static final String SQL_UPDATE_CATEGORIA_COBERTURA //
            = QueryGen.genUpdateString(
                    TABLE_NAME,
                    new String[] { "nombre", "descripcion" },
                    new String[] { "id_categoria = ?" });
    private static final String SQL_DELETE_CATEGORIA_COBERTURA //
            = QueryGen.genDeleteString(
                    TABLE_NAME,
                    new String[] { "id_categoria = ?" });
}
