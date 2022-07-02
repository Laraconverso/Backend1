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
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Julian", "Alvarez", "12345678", new Date(), domicilio));
        Odontologo o = odontologoService.guardar(new Odontologo(19034, "Juan", "Dentista"));
        Turno turno = turnoService.registrarTurno(new Turno(p, o, new Date()));
        Assert.assertNotNull(turnoService.buscar(turno.getId()));
    }

    @Test
    public void eliminarTurnoTest() throws ResourceNotFoundException {
        Assert.assertNotNull(turnoService.buscar(1));
        turnoService.eliminarTurno(1);
        Assert.assertTrue(turnoService.buscar(1)==null);
    }

    @Test
    public void traerTodosLosTurnos() {
        List<Turno> turnos = turnoService.buscarTodos();
        Assert.assertTrue(!turnos.isEmpty());
        Assert.assertTrue(turnos.size() > 0);
        System.out.println(turnos);
    }

   //falta actualizar

}