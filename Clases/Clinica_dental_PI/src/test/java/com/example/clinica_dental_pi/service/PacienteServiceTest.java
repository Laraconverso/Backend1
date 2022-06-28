package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.model.Domicilio;
import com.example.clinica_dental_pi.model.Paciente;
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
public class PacienteServiceTest {

    //private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    @Autowired
    private PacienteService pacienteService;

    //private DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());
    @Autowired
    private DomicilioService domicilioService;


    //@BeforeClass
    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av PaseoColon", "850", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        Domicilio domicilio1 = new Domicilio("Av 9 de Julio", "1", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente("Bianca", "Perez", "99999999", new Date(), domicilio1));
    }


    @Test
    public void agregarYBuscarPacienteTest() {
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(1);
        Assert.assertTrue(pacienteService.buscar(1) == null);
    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }

    //falta actualizar
}