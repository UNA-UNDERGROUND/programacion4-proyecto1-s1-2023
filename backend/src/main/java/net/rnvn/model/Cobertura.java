package net.rnvn.model;

import java.math.BigDecimal;

public class Cobertura {
    private int id_cobertura;
    private int id_categoria;
    private String nombre;
    private String descripcion;
    private BigDecimal valor_minimo;
    private BigDecimal valor_porcentage;
    
    public Cobertura(int id_cobertura, int id_categoria, String nombre, String descripcion, BigDecimal valor_minimo,
            BigDecimal valor_porcentage) {
        this.id_cobertura = id_cobertura;
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor_minimo = valor_minimo;
        this.valor_porcentage = valor_porcentage;
    }

    public int getId_cobertura() {
        return id_cobertura;
    }

    public void setId_cobertura(int id_cobertura) {
        this.id_cobertura = id_cobertura;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValor_minimo() {
        return valor_minimo;
    }

    public void setValor_minimo(BigDecimal valor_minimo) {
        this.valor_minimo = valor_minimo;
    }

    public BigDecimal getValor_porcentage() {
        return valor_porcentage;
    }

    public void setValor_porcentage(BigDecimal valor_porcentage) {
        this.valor_porcentage = valor_porcentage;
    }
    
}
