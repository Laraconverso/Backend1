package com.example.Spring_Final.service;


import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.dao.impl.OdontologoDaoH2;
import com.example.Spring_Final.model.Odontologo;
import com.example.Spring_Final.model.Paciente;


import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo guardar(Odontologo od){
        return odontologoDao.guardar(od);
    }

    public Odontologo buscar(int id){
        return odontologoDao.buscar(id);
    }

    public Odontologo actualizar(Odontologo p) {
        return odontologoDao.actualizar(p);
    }

    public void eliminar(Integer id) {
        odontologoDao.eliminar(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoDao.buscarTodos();
    }
}
