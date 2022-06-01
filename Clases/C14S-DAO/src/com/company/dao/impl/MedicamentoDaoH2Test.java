package com.company.dao.impl;

import com.company.model.Medicamento;
import com.company.service.MedicamentoService;
import org.apache.log4j.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class MedicamentoDaoH2Test {
    MedicamentoService medicamentoService= new MedicamentoService(new MedicamentoDaoH2());
    Medicamento medicamento = new Medicamento(1,23, "Ibuprofeno", "Bayer", 20, 1000.0);
    //Medicamento medicamento2 = new Medicamento(2,520, "Zinc", "Pfizer", 3, 5000.0);

    private static final Logger logger = Logger.getLogger(MedicamentoDaoH2Test.class);

    @org.junit.jupiter.api.Test
    void guardar() {
        Medicamento medicamento_test = medicamentoService.guardar(medicamento);
        assertNotNull(medicamento_test,"El medicamento guardado no es nulo.");
        logger.info("Se ejecuto el test de guardar");
    }

    @org.junit.jupiter.api.Test
    void buscar() {
        Medicamento medicamento_test2 = medicamentoService.buscar(medicamento.getId());
        assertNotNull(medicamento_test2,"El medicamento guardado no es nulo.");
        logger.info("Se ejecuto el test de buscar");
    }
}