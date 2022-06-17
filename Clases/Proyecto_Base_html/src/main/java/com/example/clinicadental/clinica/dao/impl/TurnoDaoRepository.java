package com.example.clinicadental.clinica.dao.impl;

import com.example.clinicadental.clinica.dao.IDao;
import com.example.clinicadental.clinica.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoDaoRepository implements IDao<Turno> {

    private List<Turno> turnos = new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        for (Turno turno : turnos){
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        Turno turno = buscar(id);
        turnos.remove(turno);

    }

    @Override
    public List<Turno> buscarTodos() {

        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        int index = -1;
        for (int i = 0; i < turnos.size(); i++) {
            if (turnos.get(i).getId().equals(turno.getId())) {
                index = i;
            }
        }
        turnos.set(index, turno);
        return turno;
    }

}