package com.company;

public class ServicioDescarga implements IServicioDescarga{

    @Override
    public String descargar(String cancion) {
        System.out.println("Descargando ...  "+ cancion);
        System.out.println("EXITO! Cancion descargada.");
        return("EXITO! Cancion descargada.");
    }
}
