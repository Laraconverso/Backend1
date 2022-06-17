package com.example.clinicadental.clinica.service;

import com.example.clinicadental.clinica.dao.IDao;
import com.example.clinicadental.clinica.model.Domicilio;

import java.util.List;

public class DomicilioService {
    private IDao<Domicilio> domicilioDao;

    public DomicilioService(IDao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }

    public Domicilio guardar(Domicilio d){
        domicilioDao.guardar(d);
        return d;
    }

    public void eliminar(Integer id){
        domicilioDao.eliminar(id);
    }

    public Domicilio buscar(Integer id){
        return domicilioDao.buscar(id);
    }

    public List<Domicilio> buscarTodos(){
        return domicilioDao.buscarTodos();
    }

    public Domicilio actualizar(Domicilio domicilio){
        return domicilioDao.actualizar(domicilio);
    }

}
