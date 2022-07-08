package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.repository.PacienteRepository;
import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Paciente;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;
    private static final Logger logger = Logger.getLogger(PacienteService.class);


    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteRepository.save(p);
    }

    public Paciente buscar(Integer id) {
        Paciente paciente = null;
        Optional<Paciente> optionaPaciente= pacienteRepository.findById(id);
            if (optionaPaciente.isPresent()){
                paciente= optionaPaciente.get();
            }
        return paciente;
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        if (buscar(id) == null){
            logger.error("Se quiere eliminar un paciente con un id inexistente en la base de datos.");
            throw new ResourceNotFoundException("No existe un paciente con el ID: " + id);
        }
        pacienteRepository.deleteById(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}