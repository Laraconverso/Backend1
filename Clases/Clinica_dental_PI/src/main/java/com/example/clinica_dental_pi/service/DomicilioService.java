package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.Repository.DomicilioRepository;
import com.example.clinica_dental_pi.model.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class DomicilioService {

    //@Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        return domicilioRepository.save(d);
    }

    public Domicilio buscar(Integer id){
        Domicilio domicilio = null;
        Optional<Domicilio> optionalDomicilio= domicilioRepository.findById(id);
        if (optionalDomicilio.isPresent()){
            domicilio= optionalDomicilio.get();
        }
        return domicilio;
    }

    public List<Domicilio> buscarTodos(){
        return domicilioRepository.findAll();
    }

    public void eliminar(Integer id){
        domicilioRepository.deleteById(id);
    }

}
