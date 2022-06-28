package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.model.Domicilio;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


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

    @Test
    public void agregarYBuscarPacienteTest() {
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Assert.assertNotNull(domicilioService.buscar(domicilio.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        domicilioService.eliminar(1);
        Assert.assertTrue(domicilioService.buscar(1) == null);
    }

    @Test
    public void traerTodos() {
        List<Domicilio> domicilios = domicilioService.buscarTodos();
        Assert.assertTrue(!domicilios.isEmpty());
        Assert.assertTrue(domicilios.size() > 0);
        System.out.println(domicilios);
    }


}