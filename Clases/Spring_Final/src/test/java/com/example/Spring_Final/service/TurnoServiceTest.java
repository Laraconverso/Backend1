package com.example.Spring_Final.service;


import com.example.Spring_Final.model.Domicilio;
import com.example.Spring_Final.model.Odontologo;
import com.example.Spring_Final.model.Paciente;
import com.example.Spring_Final.model.Turno;
import com.example.Spring_Final.dao.impl.TurnoRepository;
import com.example.Spring_Final.dao.impl.OdontologoDaoH2;
import com.example.Spring_Final.dao.impl.PacienteDaoH2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TurnoServiceTest {
    TurnoService turnoService = new TurnoService(new TurnoRepository());
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    PacienteService pacienteService = new PacienteService(new PacienteDaoH2());


    @Test
    public void agregarYBuscarTurnosTest() {
        System.out.println("==============================");
        System.out.println("TEST AGREGAR Y BUSCAR TURNOS");
        System.out.println("==============================");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo(001, "Martin", "Rodriguez"));
        Turno turno = turnoService.registrarTurno(new Turno(1,paciente,odontologo,new Date()));

        Assert.assertNotNull(turnoService.buscar(turno.getId()));
        //turnoService.eliminar(turno.getId());
    }

    @Test
    public void eliminarOdontologoTest() {
        System.out.println("==============================");
        System.out.println("TEST ELIMINAR TURNO");
        System.out.println("==============================");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo(001, "Martin", "Rodriguez"));
        Turno turno = turnoService.registrarTurno(new Turno(2,paciente,odontologo,new Date()));

        turnoService.eliminarTurno(turno.getId());
        Assert.assertTrue(turnoService.buscar(turno.getId()) == null);

    }

    @Test
    public void buscarTodosOdontologoTest() {
        System.out.println("==============================");
        System.out.println("TEST BUSCAR TODOS LOS TURNOS");
        System.out.println("==============================");
        Odontologo odontologo1 = new Odontologo(002, "Nicolas", "Avigliano");
        Odontologo odontologo2 = new Odontologo(003, "Violeta", "Matorras");
        Domicilio domicilio1 = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente paciente1 = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio1));
        Domicilio domicilio2 = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente2 = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio2));

        Turno turno1 = new Turno(3,paciente1,odontologo1,new Date());
        Turno turno2 = new Turno(4, paciente2,odontologo2, new Date());

        turnoService.registrarTurno(turno1);
        turnoService.registrarTurno(turno2);

        int tamanio = turnoService.buscarTodos().size();
        Assert.assertEquals(tamanio, turnoService.buscarTodos().size());

        turnoService.eliminarTurno(turno1.getId());
        turnoService.eliminarTurno(turno2.getId());
    }
}
