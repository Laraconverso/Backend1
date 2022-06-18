package com.example.Spring_Final.dao.impl;

import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.model.Turno;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TurnoRepository implements IDao<Turno> {

    private final static Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private List<Turno> turnos = new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        logger.info("cargando un nuevo turno");
        turnos.add(turno);
        logger.info("nuevo turno ingresado: " + turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        logger.info("buscando un nuevo turno con id: " + id);
        for (Turno turno : turnos){
            if(turno.getId().equals(id)){
                logger.info("turno con id: "+ id + " encontrado " + turno);
                return turno;
            }
        }
        logger.error("turno no encontrado");
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        logger.info("eliminando turno con id: " + id);
        Turno turno = buscar(id);
        turnos.remove(turno);
        logger.info("turno eliminado con id: " + id);
    }

    @Override
    public List<Turno> buscarTodos() {
        logger.info("buscando todos los turnos");
        logger.info("econtramos todos los turnos " + turnos);
        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        logger.info("actualizando turno");
        int index = -1;
        for (int i = 0; i < turnos.size(); i++) {
            if (turnos.get(i).getId().equals(turno.getId())) {
                index = i;
            }
        }
        turnos.set(index, turno);
        logger.info("turno actualizado: " + turno);
        return turno;
    }

}