package com.company;

public class Serie implements ISerie{

    //atributo
    private String nombre;

    public Serie(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getSerie(String nombre) {
        return "www." + this.nombre;
    }
}
