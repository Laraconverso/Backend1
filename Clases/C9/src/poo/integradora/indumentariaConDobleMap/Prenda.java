package poo.integradora.indumentariaConDobleMap;

import java.util.Objects;

public class Prenda {
    private String tipo;

    public Prenda(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenda that = (Prenda) o;
        return tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }

    @Override
    public String toString() {
        return "\nPrenda:" +
                "\n\tTipo: '" + tipo + "'";
    }
}
