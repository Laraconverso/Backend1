package com.company;

import com.company.dao.impl.MedicamentoDaoH2;
import com.company.model.Medicamento;
import com.company.service.MedicamentoService;

public class Main {

    public static void main(String[] args) {
        Medicamento medicamento= new Medicamento(1,23, "Ibuprofeno", "Bayer", 20, 1000.0);


        MedicamentoService medicamentoService= new MedicamentoService(new MedicamentoDaoH2());

        Medicamento medicamento2= new Medicamento(2,520, "Zinc", "Pfizer", 3, 5000.0);


        //Esto debería guardar en la tabla de la BD
        medicamentoService.guardar(medicamento);
        medicamentoService.guardar(medicamento2);

        //Se busca un medicamente
        medicamentoService.buscar(medicamento.getId());
        medicamentoService.buscar(3);
    }
}
