package com.example.C38SMongoDB.service;

import com.example.C38SMongoDB.model.Partido;
import com.example.C38SMongoDB.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {
    private PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public Partido agregar(Partido partido){
        return partidoRepository.save(partido);
    }
    public List<Partido> listar(){
        return partidoRepository.findAll();
    }

    public List<Partido> partidosEnVivo(){
        return partidoRepository.findAllByEstado("En vivo");
    }


}
