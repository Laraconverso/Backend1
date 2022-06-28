package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.model.Odontologo;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    //@BeforeClass
    public void cargarDataSet() {
        Odontologo odontologo = odontologoService.guardar(new Odontologo(19034, "Juan", "Dentista"));
        Odontologo odontologo1 = odontologoService.guardar(new Odontologo(2345, "Perla", "Blancas"));
    }

    @Test
    public void agregarYBuscarOdontologoTest() {
        this.cargarDataSet();
        Odontologo o = odontologoService.guardar(new Odontologo(350, "Nombre", "Apellido"));
        Assert.assertNotNull(odontologoService.buscar(o.getId()));
    }


    @Test
    public void eliminarOodntologoTest() {
        Assert.assertNotNull(odontologoService.buscar(1));
        odontologoService.eliminar(1);
        Assert.assertTrue(odontologoService.buscar(1)==null);
    }

    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() > 0);
        System.out.println(odontologos);
    }

    //falta actualizar

}