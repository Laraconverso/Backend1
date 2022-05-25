package poo.test.indumentaria;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import poo.integradora.indumentaria.Prenda;
import poo.integradora.indumentaria.PrendaFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrendaFactoryTest {

    private PrendaFactory prendaFactory;

    @BeforeEach
    public void init() {
        prendaFactory = new PrendaFactory();
    }

    @Test
    public void test01AlAgregarUnaPrendaElTamanioDeLaCacheEs1() {
        String talle = "L";
        String tipo = "Remera";
        boolean esNuevo = true;
        boolean importada = false;

        prendaFactory.crearPrenda(talle, tipo, esNuevo, importada);

        assertEquals(prendaFactory.tamanioCache(), 1);
    }

    @Test
    public void test02AlAgregarDosPrendasIgualesElTamanioDeLaCacheEs1() {
        String talle = "L";
        String tipo = "Remera";
        boolean esNuevo = true;
        boolean importada = false;

        prendaFactory.crearPrenda(talle, tipo, esNuevo, importada);
        prendaFactory.crearPrenda(talle, tipo, esNuevo, importada);

        assertEquals(prendaFactory.tamanioCache(), 1);
    }

    @Test
    public void test03AlAgregarDosPrendasDelMismoTipoElTamanioDeLaCacheEs1() {
        String talle1 = "L", talle2 = "M";
        String tipo = "Remera";
        boolean esNuevo = true;
        boolean importada = false;

        prendaFactory.crearPrenda(talle1, tipo, esNuevo, importada);
        prendaFactory.crearPrenda(talle2, tipo, !esNuevo, !importada);

        assertEquals(prendaFactory.tamanioCache(), 1);
    }
    
    @Test
    public void test04SeCreaLaPrendaCorrecta() {
        String talle = "L";
        String tipo = "Remera";
        boolean esNuevo = true;
        boolean importada = false;
        Prenda prendaEsperada = new Prenda(talle, tipo, esNuevo, importada);

        Prenda prendaCreada = prendaFactory.crearPrenda(talle, tipo, esNuevo, importada);

        assertEquals(prendaEsperada, prendaCreada);
    }
}
