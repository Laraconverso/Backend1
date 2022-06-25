package com.example.clinica_dental_pi.service;


import com.example.clinica_dental_pi.Repository.impl.TurnoRepository;
import com.example.clinica_dental_pi.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    //private IDao<Turno> turnoRepository;
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
        return turnoRepository.findById(id).get();
    }

}
