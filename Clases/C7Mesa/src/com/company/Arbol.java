package com.company;

public class Arbol {
    private int alto;
    private int ancho;
    private String color;
    private String tipoArbol;

    public Arbol(int alto, int ancho, String color, String tipoArbol) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        this.tipoArbol = tipoArbol;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "alto=" + alto +
                ", ancho=" + ancho +
                ", color='" + color + '\'' +
                ", tipoArbol='" + tipoArbol + '\'' +
                '}';
    }
}
