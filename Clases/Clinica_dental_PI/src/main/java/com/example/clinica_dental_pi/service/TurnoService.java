package com.example.clinica_dental_pi.service;


import com.example.clinica_dental_pi.Repository.TurnoRepository;
import com.example.clinica_dental_pi.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }

    public Turno registrarTurno(Turno turno){
        return turnoRepository.save(turno);
    }

    public void eliminarTurno(Integer id) {
        turnoRepository.deleteById(id);
    }

    public Turno actualizar(Turno t) {
        return turnoRepository.save(t);
    }

    public Turno buscar(Integer id) {
        Turno turno = null;
        Optional<Turno> optionalTurno= turnoRepository.findById(id);
        if (optionalTurno.isPresent()){
            turno= optionalTurno.get();
        }
        return turno;
    }

}
