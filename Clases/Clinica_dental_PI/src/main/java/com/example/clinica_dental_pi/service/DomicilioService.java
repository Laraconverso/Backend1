package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.Repository.impl.DomicilioRepository;
import com.example.clinica_dental_pi.model.Domicilio;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class DomicilioService {
    //private IDao<Domicilio> domicilioDao;
    private DomicilioRepository domicilioRepository;


    /*public DomicilioService(IDao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }*/
    //Nuevo constructor (inyecta la dependencia del Repository)
    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    public Domicilio guardar(Domicilio d){
        //domicilioDao.guardar(d);
        //return d;
        return domicilioRepository.save(d);
    }

    public Domicilio buscar(Integer id){
        //return domicilioDao.buscar(id);
        return domicilioRepository.findById(id).get();
    }

    public List<Domicilio> buscarTodos(){
        //return domicilioDao.buscarTodos();
        return domicilioRepository.findAll();
    }

    public void eliminar(Integer id){
        //domicilioDao.eliminar(id);
        domicilioRepository.deleteById(id);
    }

}
