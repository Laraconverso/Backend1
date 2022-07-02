package com.example.C38S.service;

import com.example.C38S.model.Partido;
import com.example.C38S.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    private PartidoRepository partidoRepository;


    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }



    public Partido crearPartido(Partido partido){
        return partidoRepository.save(partido);
    }

    public List<Partido> obtenerTodos(){
        return partidoRepository.findAll();
    }

    public List<Partido> obtenerPartidosEnVivo(){
        String EN_VIVO= "En vivo";
        return partidoRepository.findAllByEstado(EN_VIVO);
    }

}
