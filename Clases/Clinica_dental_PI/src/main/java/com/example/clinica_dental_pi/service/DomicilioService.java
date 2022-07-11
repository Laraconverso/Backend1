package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.repository.DomicilioRepository;
import com.example.clinica_dental_pi.model.Domicilio;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class DomicilioService {


    private DomicilioRepository domicilioRepository;
    private static final Logger logger = Logger.getLogger(DomicilioService.class);

    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        logger.info("Se guarda el domicilio con el id: " + d.getId());
        return domicilioRepository.save(d);
    }

    public Domicilio buscar(Integer id){
        Domicilio domicilio = null;
        Optional<Domicilio> optionalDomicilio= domicilioRepository.findById(id);
        logger.info("Se buscar el domicilio con el id: " + id);
        if (optionalDomicilio.isPresent()){
            domicilio= optionalDomicilio.get();
        }
        return domicilio;
    }

    public List<Domicilio> buscarTodos(){
        logger.info("Se buscan todos los domicilios");
        return domicilioRepository.findAll();
    }

    public void eliminar(Integer id){
        logger.info("Se elimina el domicilio con el id: " + id);
        domicilioRepository.deleteById(id);
    }

}
