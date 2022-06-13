package com.example.Spring_Final.service;


import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.model.Odontologo;


import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo guardar(Odontologo od){
        return odontologoDao.guardar(od);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoDao.buscarTodos();
    }
}
