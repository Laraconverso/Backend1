package com.company;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static Logger logger= Logger.getLogger(Main.class);
    public static void main(String[] args) {
//        try{
//            logger.info("Comienza la operación de división");
//            int resultado= 4/0;
//            logger.info("Finalizó la operación :)");
//        }catch (Exception exception){
//            logger.error("División por cero",exception);
//        }

        List<Integer> listaEnteros = new ArrayList<>();

        if (listaEnteros.size()==0)
            logger.error("La lista no puede estar vacÃ­a");

        for (int i=0;i<5;i++) {
            listaEnteros.add(i);
        }
        if (listaEnteros.size() <=5){
            logger.info("La lista tiene entre 1  y 5 elementos");
        }

        for (int i=5;i<10;i++) {
            listaEnteros.add(i);
        } if (listaEnteros.size() <=10 && listaEnteros.size() >=5){
            logger.info("La lista tiene entre 1  y 10 elementos");
        }

        double acumulador = 0;
        for (int item:  listaEnteros
        ) {
            acumulador+= item;
        }
        double promedio = acumulador/listaEnteros.size();
        logger.info("El promedio es "+ promedio);
    }
}
