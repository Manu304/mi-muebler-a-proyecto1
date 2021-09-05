package com.mrojas.pruebas.mi_muebleria.models;

public class Cliente {
    private Integer id;
    private String nit;
    private String nombre;
    private String direccion;
    private String municipio;
    private String departamento;

    public Cliente() {
    }

    public Cliente(Integer id, String nit, String nombre, String direccion) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Cliente(Integer id, String nit, String nombre, String direccion, String municipio, String departamento) {
        this(id, nit, nombre, direccion);
        this.municipio = municipio;
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
