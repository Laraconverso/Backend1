package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.Repository.PacienteRepository;
import com.example.clinica_dental_pi.model.Paciente;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

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

    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}