package com.example.proyectofinal.DataVehiculo;

public class Autos {
    private String marca;
    private String modelo;
    private Integer anio;
    private String tipoaceite;


    public Autos(String marca, String modelo, Integer anio, String tipoaceite) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipoaceite = tipoaceite;
    }

    public Autos(){}

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

    public Integer getAnio() {

        return anio;
    }

    public void setAnio(Integer anio) {

        this.anio = anio;
    }

    public String getTipoaceite() {
        return tipoaceite;
    }

    public void setTipoaceite(String tipoaceite) {

        this.tipoaceite = tipoaceite;
    }
}