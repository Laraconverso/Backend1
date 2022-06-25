package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.model.Domicilio;
import com.example.clinica_dental_pi.model.Odontologo;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DomicilioServiceTest {

    @Autowired
    private DomicilioService domicilioService;

    //@BeforeClass
    public void cargarDataSet() {
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Mi casa", "1", "CABA", "Buenos Aires"));
        Domicilio domicilio1 = domicilioService.guardar(new Domicilio("Tu casa", "12", "CABA", "Buenos Aires"));
    }

}