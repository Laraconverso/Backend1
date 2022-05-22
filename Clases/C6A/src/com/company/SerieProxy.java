package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SerieProxy implements ISerie{

    //atributo
    private int cantVistas;
    private Serie serie;
    //private ArrayList fechasPeticion;
    private LocalDate primerDiaSemanaActual;

    public LocalDate getSemanaActual() {
        return primerDiaSemanaActual;
    }

    public void setSemanaActual(LocalDate semanaActual) {
        this.primerDiaSemanaActual = primerDiaSemanaActual;
    }


    public SerieProxy(int cantVistas, Serie serie) {
        this.cantVistas = cantVistas;
        this.serie = serie;
    }

    public int getCantVistas() {
        return cantVistas;
    }

    public void setCantVistas(int cantVistas) {
        this.cantVistas = cantVistas;
    }
    @Override
    public String getSerie(String nombre) {

        if(this.getCantVistas()<=5) {
            serie.getSerie(nombre);
            //fechasPeticion.add("HAY QUE AGREGARLE EL METODO DATE. NOW ");
            this.setCantVistas(getCantVistas() + 1);
            return "Se puede ver la serie.";
        }
        return "Has superado la cantidad de reproducciones permitidas para " + nombre;
    }



}
