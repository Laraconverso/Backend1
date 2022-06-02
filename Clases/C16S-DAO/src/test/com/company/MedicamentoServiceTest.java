package test.com.company;

import com.company.dao.impl.MedicamentoDaoH2;
import com.company.model.Medicamento;
import com.company.service.MedicamentoService;
import org.junit.Assert;
import org.junit.Test;

public class MedicamentoServiceTest {


    private MedicamentoService medicamentoService= new MedicamentoService(new MedicamentoDaoH2());


    @Test
    public void guardarMedicamento(){
        //Creo un objeto medicamento
        Medicamento medicamento= new Medicamento(123,"Paracetamol","Bayer",1,150.00);
        medicamentoService.guardar(medicamento);
        Assert.assertTrue(medicamentoService.buscar(1) != null);
    }

    @Test
    public void buscarPorId(){
        Medicamento medicamentoEncontrado= medicamentoService.buscar(1);
        //Assert.assertTrue(medicamentoEncontrado != null);
        Assert.assertNotNull(medicamentoEncontrado);
    }


}
