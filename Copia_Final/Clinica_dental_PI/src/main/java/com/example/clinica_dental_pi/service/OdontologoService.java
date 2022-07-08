package com.example.clinica_dental_pi.service;


import com.example.clinica_dental_pi.repository.OdontologoRepository;
import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private OdontologoRepository odontologoRepository;
    private static final Logger logger = Logger.getLogger(OdontologoService.class);


    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo od){
        return odontologoRepository.save(od);
    }

    public Odontologo buscar(int id){
        Odontologo odontologo = null;
        Optional<Odontologo> optionalOdontologo= odontologoRepository.findById(id);
        if (optionalOdontologo.isPresent()){
            odontologo= optionalOdontologo.get();
        }
        return odontologo;
    }

    public Odontologo actualizar(Odontologo p) {
        return odontologoRepository.save(p);
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        //odontologoRepository.deleteById(id);
        if (this.buscar(id)==null){
            logger.error("Se quiere eliminar un odontologo con un id inexistente en la base de datos.");
            throw new ResourceNotFoundException("No existe un odontologo con el ID: " +id);
        } else{
            odontologoRepository.deleteById(id);
        }
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }
}
