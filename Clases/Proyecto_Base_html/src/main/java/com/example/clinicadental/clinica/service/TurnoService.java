package com.example.clinicadental.clinica.service;

import com.example.clinicadental.clinica.dao.IDao;
import com.example.clinicadental.clinica.model.Turno;

import java.util.Date;
import java.util.List;

public class TurnoService {

    private IDao<Turno> turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    public Turno guardar(Turno turno) {
        turno.setFecha(new Date());
        return turnoIDao.guardar(turno);
    }

    public void eliminar(Integer id) {
        turnoIDao.eliminar(id);
    }

    public Turno buscar(Integer id) {
        return turnoIDao.buscar(id);
    }

    public List<Turno> buscarTodos() {
        return turnoIDao.buscarTodos();
    }

    public Turno actualizar(Turno turno) {
        return turnoIDao.actualizar(turno);
    }
}
