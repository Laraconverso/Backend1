package com.company;

import com.company.dao.impl.MedicamentoDaoH2;
import com.company.model.Medicamento;
import com.company.service.MedicamentoService;

public class Main {

    public static void main(String[] args) {
        //Creo un objeto medicamento
        //Medicamento medicamento= new Medicamento(1,123,"Paracetamol","Bayer",1,150.00);
        /*Medicamento medicamento= new Medicamento(123,"Paracetamol","Bayer",1,150.00);

        //Creo un Service
        MedicamentoService medicamentoService= new MedicamentoService(new MedicamentoDaoH2());

        //Solicitar al service que persita el objeto en una BD
        medicamentoService.guardar(medicamento);

        //Se busca un medicamento
        //Medicamento medicamentoObtenido= medicamentoService.buscar(medicamento.getId());
        Medicamento medicamentoObtenido= medicamentoService.buscar(1);*/

    }
}
