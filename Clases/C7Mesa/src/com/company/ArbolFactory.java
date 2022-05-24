package com.company;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    public static final Map<String, Arbol> arbolMap = new HashMap<>();

    public static Arbol getArbol(int alto, int ancho, String color, String tipoArbol){
        String clave = "key: " + tipoArbol;

        Arbol arbol = arbolMap.get(clave);
        if (arbol == null){
            arbol = new Arbol(alto, ancho, color, tipoArbol);
            arbolMap.put(clave, arbol);
            System.out.println("Creo un arbol de tipo: " + tipoArbol);

        }
        return arbol;
    }
}
