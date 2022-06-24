package com.example.C34S.service;

import com.example.C34S.model.Jugador;
import com.example.C34S.repository.JugadorRepository;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {

    private JugadorRepository jugadorRepository;


    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }


    public Jugador buscarPorNombre(String nombre){
        return jugadorRepository.findByNombre(nombre);
    }

}
