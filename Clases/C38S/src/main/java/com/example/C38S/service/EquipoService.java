package com.example.C38S.service;


import com.example.C38S.model.EquipoLocal;
import com.example.C38S.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    private EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public EquipoLocal guardar(EquipoLocal equipo){
        return equipoRepository.save(equipo);
    }

    public List<EquipoLocal> listar(){
        return equipoRepository.findAll();
    }
}
