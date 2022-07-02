package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.exceptions.BadRequestException;
import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Domicilio;
import com.example.clinica_dental_pi.model.Odontologo;
import com.example.clinica_dental_pi.model.Paciente;
import com.example.clinica_dental_pi.model.Turno;
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

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;


    @Test
    public void agregarYBuscarTurnoTest() throws BadRequestException {
        System.out.println("-------- Test agregar y buscar paciente --------\n");
        System.out.println("------------------------------------------------\n");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Julian", "Alvarez", "12345678", new Date(), domicilio));
        Odontologo o = odontologoService.guardar(new Odontologo(19034, "Juan", "Dentista"));
        Turno turno = turnoService.registrarTurno(new Turno(p, o, new Date()));
        Assert.assertNotNull(turnoService.buscar(turno.getId()));
    }

    @Test
    public void eliminarTurnoTest() throws ResourceNotFoundException {
        System.out.println("-------- Test eliminar paciente --------\n");
        System.out.println("----------------------------------------\n");
        Assert.assertNotNull(turnoService.buscar(1));
        turnoService.eliminarTurno(1);
        Assert.assertTrue(turnoService.buscar(1)==null);
    }

    @Test
    public void traerTodosLosTurnos() {
        System.out.println("-------- Test traer turnos --------\n");
        System.out.println("-----------------------------------\n");
        List<Turno> turnos = turnoService.buscarTodos();
        Assert.assertTrue(!turnos.isEmpty());
        Assert.assertTrue(turnos.size() > 0);
        System.out.println(turnos);
    }

    @Test
    public void actualizarTurnoTest() throws BadRequestException {
        System.out.println("\n---------------------------------------\n");
        System.out.println("-------- Test actualizar Turno --------\n");
        System.out.println("---------------------------------------\n");
        Domicilio d = new Domicilio("Av. Las Heras","1200","Capital", "Bs.As.");
        Paciente p = new Paciente(1,"Virginia", "Perez", "1234563", new Date(), d);
        Odontologo o = new Odontologo(1,235, "Blancas", "Perlas");
        Turno t = turnoService.registrarTurno(new Turno(34, p ,o, new Date()));
        Odontologo o2 = new Odontologo(100, "Odolito", "Dental");
        Turno t2 = new Turno(t.getId(),p, o2, new Date());

        t = turnoService.actualizar(t2);

        Assert.assertEquals(turnoService.buscar(t.getId()).getOdontologo().getNombre(), "Odolito");
        System.out.println(p);
    }

}