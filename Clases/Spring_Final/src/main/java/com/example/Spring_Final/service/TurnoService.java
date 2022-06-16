package com.example.Spring_Final.service;

import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.model.Paciente;
import com.example.Spring_Final.model.Turno;

import java.util.List;

public class TurnoService {

    private IDao<Turno> turnoRepository;

    public TurnoService(IDao<Turno> turnoRepository){
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.buscarTodos();
    }

    public Turno registrarTurno(Turno turno){
        return turnoRepository.guardar(turno);
    }

    public void eliminarTurno(Integer id) {
        turnoRepository.eliminar(id);
    }

    public Turno actualizar(Turno t) {
        return turnoRepository.actualizar(t);
    }

    public Turno buscar(Integer id) {
        return turnoRepository.buscar(id);
    }

}
