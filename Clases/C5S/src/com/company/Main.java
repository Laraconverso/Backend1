package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("01","Premium");
        Usuario usuario2 = new Usuario("02","Free");

        IServicioDescarga proxyUs1 = new ProxyDescarga(usuario1, new ServicioDescarga());
        IServicioDescarga proxyUs2 = new ProxyDescarga(usuario2, new ServicioDescarga());

        proxyUs1.descargar("LaLaLa");
        proxyUs2.descargar("Yellow");

    }
}
