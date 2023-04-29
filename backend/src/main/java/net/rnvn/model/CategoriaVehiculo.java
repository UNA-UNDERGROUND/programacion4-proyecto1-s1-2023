package net.rnvn.model;

public class CategoriaVehiculo {

    private int categoria_vehiculo;
    private String marca;
    private String modelo;
    private int serie;
    
    public CategoriaVehiculo(int categoria_vehiculo, String marca, String modelo, int serie) {
        this.categoria_vehiculo = categoria_vehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
    }

    public int getCategoria_vehiculo() {
        return categoria_vehiculo;
    }

    public void setCategoria_vehiculo(int categoria_vehiculo) {
        this.categoria_vehiculo = categoria_vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

}
