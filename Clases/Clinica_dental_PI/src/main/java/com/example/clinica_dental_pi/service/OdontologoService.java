package com.example.clinica_dental_pi.service;


import com.example.clinica_dental_pi.Repository.impl.OdontologoRepository;
import com.example.clinica_dental_pi.model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    //private IDao<Odontologo> odontologoIDao;
    private OdontologoRepository odontologoRepository;


//    public OdontologoService(IDao<Odontologo> odontologoDao) {
//        this.odontologoIDao = odontologoDao;
//    }


    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo od){
        return odontologoRepository.save(od);
    }

    public Odontologo buscar(int id){
        return odontologoRepository.findById(id).get();
    }

    public Odontologo actualizar(Odontologo p) {
        return odontologoRepository.save(p);
    }

    public void eliminar(Integer id) {
        odontologoRepository.deleteById(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }
}
