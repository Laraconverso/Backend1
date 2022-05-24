package com.company;

public class Main {

    public static void main(String[] args) {
        ArbolFactory arbolFactory = new ArbolFactory();

        arbolFactory.getArbol(500,300,"Rojo", "Frutal");
        arbolFactory.getArbol(500,300,"Rojo", "Frutal");
        arbolFactory.getArbol(500,300,"Rojo", "Frutal");
        arbolFactory.getArbol(200, 400, "Verde", "Ornamental");

    }
}
