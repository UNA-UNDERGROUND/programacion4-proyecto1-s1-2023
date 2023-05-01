package net.rnvn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.rnvn.db.PolizasDAO;
import net.rnvn.db.QueryGen;
import net.rnvn.model.MedioPago;

public class MedioPagoDAO extends PolizasDAO{
    public MedioPagoDAO() {
        super();
    }

    public boolean agregarMedioPago(MedioPago medioPago) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_ADD_MEDIO_PAGO)) {

            stmt.clearParameters();
            stmt.setInt(1, medioPago.getId());
            stmt.setString(2, medioPago.getIdCliente());
            stmt.setInt(3, medioPago.getNumeroTarjeta());
            stmt.setString(4, medioPago.getNombreTitular());
            stmt.setDate(5, java.sql.Date.valueOf(medioPago.getFechaVencimiento().toLocalDate()));
            stmt.setString(6, medioPago.getCvv());
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al agregar medio de pago: " + e.getMessage());
        }
        return result;
    }

    public MedioPago getMedioPago(int idMedioPago){
        MedioPago pago = null;
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL_GET_MEDIO_PAGO)) {
            stmt.clearParameters();
            stmt.setInt(1, idMedioPago);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()){
                    String id = rs.getString("id_cliente");
                    int numeroTarjeta = rs.getInt("numero_tarjeta");
                    String nombreTitular = rs.getString("nombre_titular");
                    LocalDateTime fechaVencimiento = rs.getTimestamp("fecha_vencimiento").toLocalDateTime();
                    String cvv = rs.getString("cvv");
                    pago = new MedioPago(idMedioPago, id, numeroTarjeta, nombreTitular, fechaVencimiento, cvv);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al obtener medio de pago: " + e.getMessage());
        }
        return pago;
    }

    public boolean actualizarMedioPago(MedioPago medioPago) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_MEDIO_PAGO)) {

            stmt.clearParameters();
            stmt.setInt(1, medioPago.getId());
            stmt.setString(2, medioPago.getIdCliente());
            stmt.setInt(3, medioPago.getNumeroTarjeta());
            stmt.setString(4, medioPago.getNombreTitular());
            stmt.setDate(5, java.sql.Date.valueOf(medioPago.getFechaVencimiento().toLocalDate()));
            stmt.setString(6, medioPago.getCvv());
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al actualizar medio de pago: " + e.getMessage());
        }
        return result;
    }

    public boolean eliminarMedioPago(int id) {
        boolean result = false;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_MEDIO_PAGO)) {

            stmt.clearParameters();
            stmt.setInt(1, id);
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al eliminar medio de pago: " + e.getMessage());
        }
        return result;
    }

    public List<MedioPago> getListadoMedioPagoCliente(String idCliente) {
        ArrayList<MedioPago> listadoMedioPago = null;
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_LIST_MEDIO_PAGO_CLIENTE)) {
            stmt.clearParameters();
            stmt.setString(1, idCliente);
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                listadoMedioPago = new ArrayList<MedioPago>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int numeroTarjeta = rs.getInt("numero_tarjeta");
                    String nombreTitular = rs.getString("nombre_titular");
                    LocalDateTime fechaVencimiento = rs.getTimestamp("fecha_vencimiento").toLocalDateTime();
                    String cvv = rs.getString("cvv");
                    MedioPago medioPago = new MedioPago(
                            id,
                            idCliente,
                            numeroTarjeta,
                            nombreTitular,
                            fechaVencimiento,
                            cvv);
                    listadoMedioPago.add(medioPago);
                }
            }
        } catch (Exception e) {
            String className = this.getClass().getName();
            System.err.println("[" + className + "] Error al obtener listado de medios de pago: " + e.getMessage());
        }
        return listadoMedioPago;
    }

    // consultas SQL

    private static final String TABLE_NAME = "medio_pago";

    private static final String SQL_ADD_MEDIO_PAGO 
        = QueryGen.genInsertInto(
            TABLE_NAME,
            new String[] {"id", "id_cliente", "numero_tarjeta", "nombre_titular", "fecha_vencimiento", "cvv"});
    private static final String SQL_GET_MEDIO_PAGO
        = QueryGen.genSelectString(
            TABLE_NAME,
            new String[] {"id_cliente", "numero_tarjeta", "nombre_titular", "fecha_vencimiento", "cvv"},
            new String[] {"id = ?"});
    private static final String SQL_UPDATE_MEDIO_PAGO
        = QueryGen.genUpdateString(
            TABLE_NAME,
            new String[] {"id_cliente", "numero_tarjeta", "nombre_titular", "fecha_vencimiento", "cvv"},
            new String[] {"id = ?"});
    private static final String SQL_DELETE_MEDIO_PAGO
        = QueryGen.genDeleteString(
            TABLE_NAME,
            new String[] {"id = ?"});

    private static final String SQL_LIST_MEDIO_PAGO_CLIENTE //
            = QueryGen.genSelectString(
                    TABLE_NAME,
                    new String[] {
                            "id",
                            "id_cliente",
                            "numero_tarjeta",
                            "nombre_titular",
                            "fecha_vencimiento",
                            "cvv" },
                    new String[] { "id_cliente = ?" });
}
