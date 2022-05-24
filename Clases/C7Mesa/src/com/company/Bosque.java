package com.company;

import java.util.ArrayList;
import java.util.List;

public class Bosque{
    private List<Arbol> arboles = new ArrayList<>();

    public void plantarArbol(int alto, int ancho, String color, String tipoArbol){
        Arbol arbol = ArbolFactory.getArbol(alto, ancho, color, tipoArbol);
        arboles.add(arbol);
    }
}
