package com.company;

public class MenuInfantil extends Menu{

    private int cantidadJuguete;

    public int getCantidadJuguete() {
        return cantidadJuguete;
    }

    public void setCantidadJuguete(int cantidadJuguete) {
        this.cantidadJuguete = cantidadJuguete;

    }

    public MenuInfantil(int cantidadJuguete) {
        this.cantidadJuguete = cantidadJuguete;
        this.setNombre("menu infantil");
    }

    @Override
    public double calculcarCosto() {
        return getCantidadJuguete()*3 + getPrecioBase();
    }

    @Override
    public String toString() {
        return "MenuInfantil{" +
                "cantidad Juguetes= " + cantidadJuguete +  " precio Total= " + this.calculcarCosto() +" tipo menu= " + getNombre() +
                '}';
    }
}
