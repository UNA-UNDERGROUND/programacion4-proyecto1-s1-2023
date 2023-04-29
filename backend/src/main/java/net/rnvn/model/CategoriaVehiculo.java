package net.rnvn.model;

public class CategoriaVehiculo {

    private Integer idCategoriaVehiculo;
    private String marca;
    private String modelo;
    private int serie;

    public CategoriaVehiculo(Integer idCategoriaVehiculo, String marca, String modelo, int serie) {
        this.idCategoriaVehiculo = idCategoriaVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
    }

    public Integer getIdCategoriaVehiculo() {
        return idCategoriaVehiculo;
    }

    public void setIdCategoriaVehiculo(Integer idCategoriaVehiculo) {
        this.idCategoriaVehiculo = idCategoriaVehiculo;
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
