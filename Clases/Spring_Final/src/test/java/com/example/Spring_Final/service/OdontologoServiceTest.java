package com.example.Spring_Final.service;


import com.example.Spring_Final.dao.impl.OdontologoDaoH2;
import com.example.Spring_Final.model.Odontologo;
import org.junit.Assert;
import org.junit.Test;


public class OdontologoServiceTest {
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void agregarYBuscarOdontologosTest() {
        System.out.println("==============================");
        System.out.println("TEST AGREGAR Y BUSCAR ODONTOLOGO");
        System.out.println("==============================");
        Odontologo odontologo = odontologoService.guardar(new Odontologo(001, "Martin", "Rodriguez"));

        Assert.assertNotNull(odontologoService.buscar(odontologo.getId()));
        odontologoService.eliminar(odontologo.getId());
    }

    @Test
    public void eliminarOdontologoTest() {
        System.out.println("==============================");
        System.out.println("TEST ELIMINAR ODONTOLOGO");
        System.out.println("==============================");
        Odontologo odontologo = odontologoService.guardar(new Odontologo(002, "Martin", "Rodriguez"));
        odontologoService.eliminar(odontologo.getId());
        Assert.assertTrue(odontologoService.buscar(odontologo.getId()) == null);

    }

    @Test
    public void buscarTodosOdontologoTest() {
        System.out.println("==============================");
        System.out.println("TEST BUSCAR TODOS LOS ODONTOLOGOS");
        System.out.println("==============================");
        Odontologo odontologo1 = new Odontologo(002, "Nicolas", "Avigliano");
        Odontologo odontologo2 = new Odontologo(003, "Violeta", "Matorras");

        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        int tamanio = odontologoService.buscarTodos().size();
        Assert.assertEquals(tamanio, odontologoService.buscarTodos().size());

        odontologoService.eliminar(odontologo1.getId());
        odontologoService.eliminar(odontologo2.getId());
    }

}
