package net.rnvn.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import net.rnvn.db.PolizasDAO;
import net.rnvn.db.QueryGen;
import net.rnvn.model.PolizaVehiculo;

public class PolizaVehiculoDAO extends PolizasDAO{
    public PolizaVehiculoDAO(){
        super();
    }

    public boolean agregarPolizaVehiculo(PolizaVehiculo polizaVehiculo){
        boolean result = false;
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL_ADD_POLIZA_VEHICULO)){
            stmt.clearParameters();
            stmt.setString(1, polizaVehiculo.getIdCliente());
            stmt.setInt(2, polizaVehiculo.getIdPoliza());
            stmt.setString(3, polizaVehiculo.getPlacaVehiculo());
            stmt.setInt(4, polizaVehiculo.getIdCategoriaVehiculo());
            stmt.setBigDecimal(5, polizaVehiculo.getValorAsegurado());
            stmt.setTimestamp(6, java.sql.Timestamp.valueOf(polizaVehiculo.getFechaInicio()));
            stmt.setObject(7, polizaVehiculo.getPlazoPago());
        } catch (Exception e) {
            // TODO: handle exception
            String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al agregar poliza de vehiculo: " + e.getMessage());
        }
        return result;
    }

    public PolizaVehiculo getPolizaVehiculo(int idPoliza){
        PolizaVehiculo poliza = null;
        try (Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_GET_POLIZA_VEHICULO)){
            stmt.setInt(2, idPoliza);
            try(ResultSet rs = stmt.executeQuery()){
                String idCliente = rs.getString("id_cliente");
                String placaVehiculo = rs.getString("placa_vehiculo");
                int idCategoriaVehiculo = rs.getInt("id_categoria_vehiculo");
                BigDecimal valorAsegurado = rs.getBigDecimal("valor_asegurado");
                LocalDateTime fechaInicio = rs.getTimestamp("fecha_inicio").toLocalDateTime();
            } catch(Exception e){

            }
        } catch (Exception e) {
            // TODO: handle exception
            String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al obtener poliza de vehiculo: " + e.getMessage());
        }
        return poliza;
    }

    public boolean actualizarPolizaVehiculo(PolizaVehiculo polizaVehiculo){
        boolean result = false;
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_POLIZA_VEHICULO)){
            stmt.clearParameters();
            stmt.setString(1, polizaVehiculo.getIdCliente());
            stmt.setInt(2, polizaVehiculo.getIdPoliza());
            stmt.setString(3, polizaVehiculo.getPlacaVehiculo());
            stmt.setInt(4, polizaVehiculo.getIdCategoriaVehiculo());
            stmt.setBigDecimal(5, polizaVehiculo.getValorAsegurado());
            stmt.setDate(6, java.sql.Date.valueOf(polizaVehiculo.getFechaInicio().toLocalDate()));
            stmt.setObject(7, polizaVehiculo.getPlazoPago());
        } catch (Exception e) {
            String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al actualizar poliza de vehiculo: " + e.getMessage());
        }

    public boolean eliminarPolizaVehiculo(int idPoliza){
        boolean result = false;
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_POLIZA_VEHICULO)){
            stmt.clearParameters();
            stmt.setInt(2, idPoliza);
            result = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            String className = this.getClass().getName();
			System.err.println("[" + className + "] Error al eliminar poliza de vehiculo: " + e.getMessage());
        }

    // consultas SQL

    private static final String TABLE_NAME = "polizas_vehiculo";

    private static final String SQL_ADD_POLIZA_VEHICULO
        = QueryGen.genInsertInto(
            TABLE_NAME, 
            new String[] {"id_cliente", "id_poliza", "placa_vehiculo", "id_categoria_vehiculo", "valor_asegurado", "fecha_inicio", "plazo_pago"});
    private static final String SQL_GET_POLIZA_VEHICULO
        = QueryGen.genSelectString(
            TABLE_NAME,
            new String[] {"id_cliente", "placa_vehiculo", "id_categoria_vehiculo", "valor_asegurado", "fecha_inicio", "plazo_pago"},
            new String[] {"id_poliza = ?"});
    private static final String SQL_UPDATE_POLIZA_VEHICULO
        = QueryGen.genUpdateString(
            TABLE_NAME,
            new String[] {"id_cliente", "placa_vehiculo", "id_categoria_vehiculo", "valor_asegurado", "fecha_inicio", "plazo_pago"}, 
            new String[] {"id_poliza = ?"});
    private static final String SQL_DELETE_POLIZA_VEHICULO
        = QueryGen.genDeleteString(
            TABLE_NAME,
            new String[] {"id_poliza = ?"});
}
