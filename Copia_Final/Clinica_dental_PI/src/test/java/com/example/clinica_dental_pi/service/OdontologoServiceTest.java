package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Odontologo;
import org.apache.log4j.Logger;
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
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    private static final Logger logger = Logger.getLogger(OdontologoServiceTest.class);

    //@BeforeClass
    public void cargarDataSet() {
        Odontologo odontologo = odontologoService.guardar(new Odontologo(19034, "Juan", "Dentista"));
        Odontologo odontologo1 = odontologoService.guardar(new Odontologo(2345, "Perla", "Blancas"));
    }

    @Test
    public void agregarYBuscarOdontologoTest() {
        System.out.println("-------- Test agregar y buscar odontologo --------\n");
        System.out.println("--------------------------------------------------\n");
        this.cargarDataSet();
        Odontologo o = odontologoService.guardar(new Odontologo(350, "Nombre", "Apellido"));
        logger.info("Se guardo el odontologo con el id: " + o.getId());
        Assert.assertNotNull(odontologoService.buscar(o.getId()));
    }


    @Test
    public void eliminarOodntologoTest() throws ResourceNotFoundException {
        System.out.println("-------- Test eliminar odontologo --------\n");
        System.out.println("------------------------------------------\n");
        Odontologo o = odontologoService.guardar(new Odontologo(2385912, "ODON", "TOLOGO"));
        logger.info("Se agrego el odontologo con el id: "+ o.getId());
        Assert.assertNotNull(odontologoService.buscar(o.getId()));
        odontologoService.eliminar(1);
        logger.info("Se elimina el odontologo con el id: " + o.getId());
        Assert.assertTrue(odontologoService.buscar(1)==null);
    }

    @Test
    public void traerTodos() {
        System.out.println("-------- Test traer todos los odontologos --------\n");
        System.out.println("-----------------------------------------------\n");

        List<Odontologo> odontologos = odontologoService.buscarTodos();
        logger.info("Se buscan todos los odontologos en la base de datos.");
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() > 0);
        System.out.println(odontologos);
    }

    @Test
    public void actualizarOdontologoTest(){
        System.out.println("-------- Test actualizar odontologo --------\n");
        System.out.println("------------------------------------------\n");
        Odontologo o = odontologoService.guardar(new Odontologo(124,"ODONTOGOLO", "Paez"));
        logger.info("Se guarda el odontologo con el id: "+ o.getId() + " nombre: " + o.getNombre() + " apellido: " + o.getApellido() + " matricula: "+ o.getMatricula());
        Odontologo o_nuevo = new Odontologo(o.getId(), 124, "Odontologo", "Paez");
        o_nuevo = odontologoService.actualizar(o_nuevo);
        logger.info("Se actualiza el odontologocon con el id: "+ o_nuevo.getId() + " nombre: " + o_nuevo.getNombre() + " apellido: " + o_nuevo.getApellido() + " matricula: "+ o_nuevo.getMatricula());
        Assert.assertEquals(odontologoService.buscar(o_nuevo.getId()).getNombre(), "Odontologo");
        System.out.println(o_nuevo);
    }
}