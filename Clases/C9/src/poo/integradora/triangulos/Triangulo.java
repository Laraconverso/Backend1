package poo.integradora.triangulos;

import java.util.Objects;

public class Triangulo {

    private String color;
    private int tamanio;

    public Triangulo(String color, int tamanio) {
        this.color = color;
        this.tamanio = tamanio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangulo triangulo = (Triangulo) o;
        return tamanio == triangulo.tamanio && color.equals(triangulo.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, tamanio);
    }
}
