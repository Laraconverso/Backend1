package com.example.Paqueteria.service;

import com.example.Paqueteria.entity.Paquete;
import com.example.Paqueteria.repository.PaqueteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {

    private PaqueteRepository paqueteRepository;

    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    public Paquete guardar(Paquete paquete){
        return paqueteRepository.save(paquete);
    }

    public List<Paquete> listar(){
        return paqueteRepository.findAll();
    }

    public List<Paquete> listarEnCamino(){
        String EN_CAMINO = "en_camino";
        return paqueteRepository.findAllByEstado(EN_CAMINO);
    }

    public List<Paquete> listarEntregado(){
        String ENTREGADO= "entregado";
        return paqueteRepository.findAllByEstado(ENTREGADO);
    }

}
