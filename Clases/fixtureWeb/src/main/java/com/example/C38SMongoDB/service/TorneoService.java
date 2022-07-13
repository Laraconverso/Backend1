package com.example.C38SMongoDB.service;

import com.example.C38SMongoDB.model.Torneo;
import com.example.C38SMongoDB.repository.TorneoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoService {
    private TorneoRepository torneoRepository;

    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }


    public List<Torneo> getTorneos(){
        return torneoRepository.findAll();
    }

    public Torneo agregar(Torneo torneo){
        return torneoRepository.save(torneo);
    }
}
