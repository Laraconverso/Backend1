package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Domicilio;
import com.example.clinica_dental_pi.model.Odontologo;
import com.example.clinica_dental_pi.model.Paciente;
import com.example.clinica_dental_pi.model.Turno;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private DomicilioService domicilioService;

    private static final Logger logger = Logger.getLogger(PacienteServiceTest.class);



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
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Calle", "123", "Belgrano", "Buenos Aires"));
        Paciente paciente = pacienteService.guardar(new Paciente("Alba", "Blanca", "12345678", new Date(), domicilio));
        logger.info("Se guarda el paciente con el id: " + paciente.getId());
        Assert.assertNotNull(pacienteService.buscar(paciente.getId()));

    }

    @Test
    public void eliminarPacienteTest() throws ResourceNotFoundException {
        System.out.println("-------- Test eliminar paciente --------\n");
        System.out.println("----------------------------------------\n");
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Calle", "123", "Belgrano", "Buenos Aires"));
        Paciente paciente = pacienteService.guardar(new Paciente("Alba", "Blanca", "12345678", new Date(), domicilio));
        logger.info("Se guarda el paciente con el id: " + paciente.getId());
        pacienteService.eliminar(paciente.getId());
        logger.info("Se elimina el paciente con el id: " + paciente.getId());
        Assert.assertTrue(pacienteService.buscar(paciente.getId()) == null);
    }

    @Test
    public void traerTodosTest() {
        System.out.println("-------- Test traer todos los paciente --------\n");
        System.out.println("-----------------------------------------------\n");
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        Domicilio domicilio2 = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente paciente2 = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio2));

        List<Paciente> pacientes = pacienteService.buscarTodos();
        logger.info("Se buscan todos los pacientes en la base de datos.");
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }

    @Test
    public void actualizarPacienteTest(){
        System.out.println("-------- Test actualizar paciente --------\n");
        System.out.println("------------------------------------------\n");
        Domicilio d = domicilioService.guardar(new Domicilio("Av. Las Heras","1200","Capital", "Bs.As."));
        Paciente p = pacienteService.guardar(new Paciente("Belena", "Perez", "1234563", new Date(), d));
        logger.info("Se actualiza el paciente con el id:" + p.getId() + " Nombre: " + p.getNombre() + " Apellido: " + p.getApellido()+ " DNI: " + p.getDni());
        Paciente p_nuevo = new Paciente(p.getId(), "Belen", "Perez", "1234563", new Date(), d);
        p_nuevo = pacienteService.actualizar(p_nuevo);
        logger.info("Se actualiza el paciente con el id:" + p_nuevo.getId() + " Nombre: " + p_nuevo.getNombre() + " Apellido: " + p_nuevo.getApellido()+ " DNI: " + p_nuevo.getDni());
        Assert.assertEquals(pacienteService.buscar(p_nuevo.getId()).getNombre(), "Belen");
        System.out.println(p_nuevo);

    }
}