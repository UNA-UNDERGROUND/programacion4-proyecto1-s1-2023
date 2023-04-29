package net.rnvn.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PolizaVehiculo {
    public enum PlazoPago {
        TRIMESTRAL, SEMESTRAL, ANUAL
    }

    private String idCliente;
    private int idPoliza;
    private String placaVehiculo;
    private Integer idCategoriaVehiculo;
    private BigDecimal valorAsegurado;
    private LocalDateTime fechaInicio;
    private PlazoPago plazoPago;

    public PolizaVehiculo(String idCliente, int idPoliza, String placaVehiculo, Integer idCategoriaVehiculo,
            BigDecimal valorAsegurado, LocalDateTime fechaInicio, PlazoPago plazoPago) {
        this.idCliente = idCliente;
        this.idPoliza = idPoliza;
        this.placaVehiculo = placaVehiculo;
        this.idCategoriaVehiculo = idCategoriaVehiculo;
        this.valorAsegurado = valorAsegurado;
        this.fechaInicio = fechaInicio;
        this.plazoPago = plazoPago;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(int idPoliza) {
        this.idPoliza = idPoliza;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public Integer getIdCategoriaVehiculo() {
        return idCategoriaVehiculo;
    }

    public void setCategoriaVehiculo(Integer idCategoriaVehiculo) {
        this.idCategoriaVehiculo = idCategoriaVehiculo;
    }

    public BigDecimal getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(BigDecimal valorAsegurado) {
        this.valorAsegurado = valorAsegurado;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public PlazoPago getPlazoPago() {
        return plazoPago;
    }

    public void setPlazoPago(PlazoPago plazoPago) {
        this.plazoPago = plazoPago;
    }

}
