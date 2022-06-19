package com.example.Spring_Final.service;

import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoIDao = odontologoDao;
    }

    public Odontologo guardar(Odontologo od){
        return odontologoIDao.guardar(od);
    }

    public Odontologo buscar(int id){
        return odontologoIDao.buscar(id);
    }

    public Odontologo actualizar(Odontologo p) {
        return odontologoIDao.actualizar(p);
    }

    public void eliminar(Integer id) {
        odontologoIDao.eliminar(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }
}
