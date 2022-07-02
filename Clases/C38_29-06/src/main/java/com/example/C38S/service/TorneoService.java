package com.example.C38S.service;

import com.example.C38S.model.Torneo;
import com.example.C38S.repository.TorneoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoService {
    private TorneoRepository torneoRepository;


    //Inyectar dependencia en el constructor
    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }


    public List<Torneo> listarTorneos(){
        return torneoRepository.findAll();
    }

    public Torneo agregarTorneo(Torneo torneo){
        return torneoRepository.save(torneo);
    }

}
