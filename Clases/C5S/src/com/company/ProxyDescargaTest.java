package com.company;

import org.junit.Assert;
import org.junit.Test;


public class ProxyDescargaTest {
    @Test
    public void pruebaDescarga(){
        String resultadoEsperado1 = "EXITO! Cancion descargada.";
        String resultadoEsperado2 = "Usuario free, no tienes acceso.";

        Usuario usuario1 = new Usuario("01","Premium");
        Usuario usuario2 = new Usuario("02","Free");

        IServicioDescarga proxyUs1 = new ProxyDescarga(usuario1, new ServicioDescarga());
        IServicioDescarga proxyUs2 = new ProxyDescarga(usuario2, new ServicioDescarga());

        String resultadoObtenido1 = proxyUs1.descargar("LaLaLa");
        String resultadoObtenido2 = proxyUs2.descargar("Yellow");


        Assert.assertEquals(resultadoEsperado1,resultadoObtenido1);
        Assert.assertEquals(resultadoEsperado2,resultadoObtenido2);
    }
}