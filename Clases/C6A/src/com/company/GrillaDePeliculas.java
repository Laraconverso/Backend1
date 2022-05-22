package com.company;

public class GrillaDePeliculas implements  IGrillaDePeliculas{

    @Override
    public Pelicula getPelicula(String nombrePelicula) {
        Pelicula lapeli = null;
        switch (nombrePelicula) {
            case "The White Tiger":
                lapeli = new Pelicula("The White Tiger", "Argentina", "WWW.ARGTIGER.COM" );
                break;
            case "His Houser":
                lapeli = new Pelicula("His Houser", "Brasil", "WWW.BRAHOUSE.COM" );
                break;
            case "Over the Moon":
                lapeli = new Pelicula("Over the Moon", "Colombia", "WWW.COLMOON.COM" );
                break;
            case "Superbad":
                lapeli = new Pelicula("Superbad", "Argentina", "WWW.ARGBAD.COM" );
                break;
            case "The Prom":
                lapeli = new Pelicula("The Prom", "Brasil", "WWW.BRAPROM.COM" );
                break;
            case "The Babysitter":
                lapeli = new Pelicula("The Babysitter", "Colombia", "WWW.COLSITTER.COM" );
                break;
        }
        //System.out.println(lapeli);
        return lapeli;
    }
}
