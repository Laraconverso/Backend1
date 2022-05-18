package com.company;

public abstract class Menu {
    private String nombre;
    private double precioBase;

    public Menu() {
        this.precioBase = 1000;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double calculcarCosto();

    public String armadoMenu(){
        return null;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "precioTotal= " + this.calculcarCosto() +" tipo menu= " + nombre +
                '}';
    }
}
