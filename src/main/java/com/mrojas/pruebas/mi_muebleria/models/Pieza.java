package com.mrojas.pruebas.mi_muebleria.models;

public class Pieza{
    private Integer id, cantidad;
    private String tipo;
    private Double costo;
    
    public Pieza() {
    }

    public Pieza(Integer id, Integer cantidad, String tipo, Double costo) {
        this.id = id;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
