package com.company;

public class MenuVeggie extends Menu{

    private int cantidadEspecias;
    private int cantidadSalsas;

    public MenuVeggie(int cantidadEspecias, int cantidadSalsas) {
        this.cantidadEspecias = cantidadEspecias;
        this.cantidadSalsas = cantidadSalsas;
        this.setNombre("menu veggie");
    }

    public int getCantidadEspecias() {
        return cantidadEspecias;
    }

    public void setCantidadEspecias(int cantidadEspecias) {
        this.cantidadEspecias = cantidadEspecias;
    }

    public int getCantidadSalsas() {
        return cantidadSalsas;
    }

    public void setCantidadSalsas(int cantidadSalsas) {
        this.cantidadSalsas = cantidadSalsas;
    }

    @Override
    public double calculcarCosto() {
        return getCantidadEspecias()*(0.01*getPrecioBase())+getCantidadSalsas()*2+getPrecioBase();
    }

    @Override
    public String toString() {
        return "MenuVeggie{" +
                "cantidadEspecias=" + cantidadEspecias +
                ", cantidad Salsas= " + cantidadSalsas + " precio Total= " + this.calculcarCosto() +" tipo menu= " + getNombre() +
                '}';
    }
}
