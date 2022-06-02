package com.company.model;

public class Medicamento {
    //Atributos
    private Integer id;
    private Integer codigo;
    private String nombre;
    private String laboratorio;
    private Integer cantidad;
    private Double precio;


    //Constructor 1: Se usa para AGREGAR un nuevo medicamento en la BD (no se informa el ID porque es autoincremental)
    public Medicamento(Integer codigo, String nombre, String laboratorio, Integer cantidad, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //Constructor 2: Se usa para cuando se obtiene un medicamento de la BD
    public Medicamento(Integer id, Integer codigo, String nombre, String laboratorio, Integer cantidad, Double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
