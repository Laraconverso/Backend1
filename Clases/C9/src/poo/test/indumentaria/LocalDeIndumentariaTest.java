package poo.test.indumentaria;

import org.junit.Test;
import poo.integradora.indumentaria.LocalDeIndumentaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDeIndumentariaTest {

    @Test
    public void test01AlAgregarUnaPrendaLaCantidadDePrendasEs1() {
        LocalDeIndumentaria local = new LocalDeIndumentaria();
        String talle = "L";
        String tipo = "Remera";
        boolean esNuevo = true;
        boolean importada = false;

        local.agregarPrenda(talle, tipo, esNuevo, importada);

        assertEquals(local.cantidadPrendas(), 1);
    }

    @Test
    public void test02AlAgregarDosPrendasIgualesLaCantidadDePrendasEs2() {
        LocalDeIndumentaria local = new LocalDeIndumentaria();
        String talle = "L";
        String tipo = "Remera";
        boolean esNuevo = true;
        boolean importada = false;

        local.agregarPrenda(talle, tipo, esNuevo, importada);
        local.agregarPrenda(talle, tipo, esNuevo, importada);

        assertEquals(local.cantidadPrendas(), 2);
    }

    @Test
    public void test03AlAgregarDosPrendasDelMismoTipoLaCantidadDePrendasEs2() {
        LocalDeIndumentaria local = new LocalDeIndumentaria();
        String talle1 = "L", talle2 = "M";
        String tipo = "Remera";
        boolean esNuevo = true;
        boolean importada = false;

        local.agregarPrenda(talle1, tipo, esNuevo, importada);
        local.agregarPrenda(talle2, tipo, !esNuevo, !importada);

        assertEquals(local.cantidadPrendas(), 2);
    }
}