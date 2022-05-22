package com.company;

public interface IGrillaDePeliculas {

    Pelicula getPelicula(String nombrePelicula) throws PeliculaNoHabilitadaException;
}
