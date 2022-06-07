package com.company.service;

import com.company.dao.IDao;
import com.company.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo guardar(Odontologo od){
        return odontologoDao.guardar(od);
    }

    public List<Odontologo> listarTodos(){
        return odontologoDao.listarTodos();
    }
}
