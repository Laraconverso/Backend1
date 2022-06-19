package com.example.clinicadental.clinica.service;


import com.example.clinicadental.clinica.dao.IDao;
import com.example.clinicadental.clinica.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardar(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public void eliminar(Integer id){
        odontologoIDao.eliminar(id);
    }

    public Odontologo buscar(Integer id){
        return odontologoIDao.buscar(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }

    public Odontologo actualizar(Odontologo odontologo){
        return odontologoIDao.actualizar(odontologo);
    }

}
