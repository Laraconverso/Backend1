package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.model.Domicilio;
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
public class DomicilioServiceTest {

    @Autowired
    private DomicilioService domicilioService;
    private static final Logger logger = Logger.getLogger(DomicilioServiceTest.class);


    //@BeforeClass
    public void cargarDataSet() {
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Mi casa", "1", "CABA", "Buenos Aires"));
        Domicilio domicilio1 = domicilioService.guardar(new Domicilio("Tu casa", "12", "CABA", "Buenos Aires"));
    }

    @Test
    public void agregarYBuscarDomicilioTest() {
        this.cargarDataSet();
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Calle", "123", "Temperley", "Buenos Aires"));
        logger.info("Se guardo el domicilio con el id: " + domicilio.getId());
        Assert.assertNotNull(domicilioService.buscar(domicilio.getId()));
    }

    @Test
    public void eliminarDomicilioTest() {
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Para Borrar", "124", "ALLA", "Buenos Aires"));
        domicilioService.eliminar(domicilio.getId());
        logger.info("Se elimino el domicilio con el id: " + domicilio.getId());
        Assert.assertTrue(domicilioService.buscar(domicilio.getId()) == null);
    }

    @Test
    public void traerTodosDomicilios() {
        List<Domicilio> domicilios = domicilioService.buscarTodos();
        logger.info("Se buscan todos los domicilios.");
        Assert.assertTrue(!domicilios.isEmpty());
        Assert.assertTrue(domicilios.size() > 0);
        System.out.println(domicilios);
    }

}