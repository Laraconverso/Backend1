package com.example.Spring_Final.service;

import com.example.Spring_Final.dao.impl.DomicilioDaoH2;
import com.example.Spring_Final.dao.impl.PacienteDaoH2;
import com.example.Spring_Final.model.Domicilio;
import com.example.Spring_Final.model.Paciente;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class PacienteServiceTest {
    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private static DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());


    @Test
    public void agregarYBuscarPacienteTest(){
        System.out.println("==============================");
        System.out.println("TEST AGREGAR Y BUSCAR PACIENTE");
        System.out.println("==============================");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
        //pacienteService.eliminar(p.getId());
        //domicilioService.eliminar(domicilio.getId());
    }


    @Test
    public void eliminarPacienteTest() {
        System.out.println("==============================");
        System.out.println("TEST ELIMINAR PACIENTE");
        System.out.println("==============================");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        pacienteService.eliminar(p.getId());
        Assert.assertTrue(pacienteService.buscar(p.getId()) == null);
        domicilioService.eliminar(domicilio.getId());
        Assert.assertTrue(domicilioService.buscar(domicilio.getId()) == null);

    }

    @Test
    public void traerTodos() {
        System.out.println("==============================");
        System.out.println("TEST BUSCAR TODOS LOS PACIENTES");
        System.out.println("==============================");
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));

        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);

        pacienteService.eliminar(p.getId());
        domicilioService.eliminar(domicilio.getId());
    }
}
