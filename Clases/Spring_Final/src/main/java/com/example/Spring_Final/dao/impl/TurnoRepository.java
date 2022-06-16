package com.example.Spring_Final.dao.impl;

import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoRepository implements IDao<Turno> {

    private List<Turno> turnos = new ArrayList<>();


    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        for(Turno turno: turnos){
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        for(Turno turno: turnos){
            if(turno.getId().equals(id)){
                turnos.remove(turno);
            }
        }
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno actualizar(Turno t) {
        for(Turno turno: turnos){
            if(turno.getId().equals(t.getId())){
//                turnos.remove(turno);
//                turnos.add(t);
//                break;
                turno = t;
                return turno;
            }
        }
        return null;
    }
}
