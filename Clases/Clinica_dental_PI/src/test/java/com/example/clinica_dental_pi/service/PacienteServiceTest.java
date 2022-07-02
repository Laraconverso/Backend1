package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
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

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private DomicilioService domicilioService;


    //@BeforeClass
    public void cargarDataSet() {
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Av PaseoColon", "850", "CABA", "Buenos Aires"));
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        Domicilio domicilio1 = domicilioService.guardar(new Domicilio("Av 9 de Julio", "1", "CABA", "Buenos Aires"));
        Paciente p1 = pacienteService.guardar(new Paciente("Bianca", "Perez", "99999999", new Date(), domicilio1));
    }


    @Test
    public void agregarYBuscarPacienteTest() {
        System.out.println("-------- Test agregar y buscar paciente --------\n");
        System.out.println("------------------------------------------------\n");
        this.cargarDataSet();
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Calle", "123", "Temperley", "Buenos Aires"));
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() throws ResourceNotFoundException {
        System.out.println("-------- Test eliminar paciente --------\n");
        System.out.println("----------------------------------------\n");
        pacienteService.eliminar(1);
        Assert.assertTrue(pacienteService.buscar(1) == null);
    }

    @Test
    public void traerTodosTest() {
        System.out.println("-------- Test traer todos los paciente --------\n");
        System.out.println("-----------------------------------------------\n");
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }

    @Test
    public void actualizarPacienteTest(){
        System.out.println("-------- Test actualizar paciente --------\n");
        System.out.println("------------------------------------------\n");
        Domicilio d = new Domicilio("Av. Las Heras","1200","Capital", "Bs.As.");
        Paciente p = pacienteService.guardar(new Paciente("Belena", "Perez", "1234563", new Date(), d));
        Paciente p_nuevo = new Paciente(p.getId(), "Belen", "Perez", "1234563", new Date(), d);
        p_nuevo = pacienteService.actualizar(p_nuevo);

        Assert.assertEquals(pacienteService.buscar(p_nuevo.getId()).getNombre(), "Belen");
        System.out.println(p_nuevo);

    }
}