package com.company.service;

import com.company.dao.IDao;
import com.company.model.Medicamento;

public class MedicamentoService {
    //Atributos
    private IDao<Medicamento> medicamentoDao;

    //Constructor
    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }


    //Operaciones
    public Medicamento guardar (Medicamento medicamento){
        return medicamentoDao.guardar(medicamento);
    }

    public Medicamento buscar (Integer id){
        return medicamentoDao.buscar(id);
    }

}
