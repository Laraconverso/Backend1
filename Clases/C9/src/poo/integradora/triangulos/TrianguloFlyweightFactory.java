package poo.integradora.triangulos;

import java.util.HashSet;
import java.util.Set;

public class TrianguloFlyweightFactory {

    private final Set<Triangulo> triangulos;

    public TrianguloFlyweightFactory() {
        triangulos = new HashSet<>();
    }

    public Triangulo crearTriangulo(String color, int tamanio) {
        Triangulo resultado = null;

        for(Triangulo t: triangulos) {
            if(t.getColor().equals(color)) {
                t.setTamanio(tamanio);
                resultado = t;
            }
        }

        if(resultado == null) {
            resultado = new Triangulo(color, tamanio);
            triangulos.add(resultado);
        }
        return resultado;
    }

    public int getCacheSize() {
        return triangulos.size();
    }
}
