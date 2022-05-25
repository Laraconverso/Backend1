package poo.test.triangulos;

import org.junit.Test;
import poo.integradora.triangulos.TrianguloFlyweightFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TrianguloFlyweightFactoryTest {

    @Test
    public void test01SeMantieneElTamanoDeLaCacheAlAgregarDosTriangulosDelMismoColorYTamanio() {
        TrianguloFlyweightFactory factory = new TrianguloFlyweightFactory();
        String color = "rojo";
        int tamanio = 5;

        factory.crearTriangulo(color, tamanio);
        factory.crearTriangulo(color, tamanio);

        assertEquals(1, factory.getCacheSize());
    }

    @Test
    public void test02AumentaElTamanoDeLaCacheAlAgregarDosTriangulosDeDistintoColor() {
        TrianguloFlyweightFactory factory = new TrianguloFlyweightFactory();
        String color1 = "rojo", color2 = "azul";
        int tamanio = 5;

        factory.crearTriangulo(color1, tamanio);
        factory.crearTriangulo(color2, tamanio);

        assertEquals(2, factory.getCacheSize());
    }

    @Test
    public void test03SeMantieneElTamanoDeLaCacheAlAgregarDosTriangulosDelMismoColorPeroDistintoTamanio() {
        TrianguloFlyweightFactory factory = new TrianguloFlyweightFactory();
        String color = "rojo";
        int tamanio1 = 5, tamanio2 = 8;

        factory.crearTriangulo(color, tamanio1);
        factory.crearTriangulo(color, tamanio2);

        assertEquals(1, factory.getCacheSize());
    }
}