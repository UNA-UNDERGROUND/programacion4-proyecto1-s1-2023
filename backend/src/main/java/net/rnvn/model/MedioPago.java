package net.rnvn.model;

import java.time.LocalDateTime;

public class MedioPago {
    private int id;
    private String idCliente;
    private String numeroTarjeta;
    private String nombreTitular;
    private LocalDateTime fechaVencimiento;
    private String cvv;

    public MedioPago(int id, String idCliente, String numeroTarjeta, String nombreTitular, LocalDateTime fechaVencimiento,
            String cvv) {
        this.id = id;
        this.idCliente = idCliente;
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

   

}
