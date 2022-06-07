package test;

import com.company.dao.impl.OdontologoDaoH2;
import com.company.model.Odontologo;
import com.company.service.OdontologoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;


public class OdontologoServiceTest {

    OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());
    @Order(1)
    @Test
    public void guardarTest() {

        Odontologo od = new Odontologo(1,125, "Marcela", "Dimaria");

        Assert.assertNotNull(odontologoService.guardar(od));
    }

    @Order(2)
    @Test
    public void listarTodosTest() {

        Odontologo od1 = new Odontologo(1,145,"Rene","Favaloro");
        Odontologo od2= new Odontologo(2,208,"Pablo","Chaw");
        Odontologo od3 = new Odontologo(3,320,"Lihuen","Aprile");
        odontologoService.guardar(od1);
        odontologoService.guardar(od2);
        odontologoService.guardar(od3);

        Assert.assertEquals(3, odontologoService.listarTodos().size());
        Assert.assertNotNull(odontologoService.listarTodos());
    }





}