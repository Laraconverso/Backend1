import org.junit.Assert;
import org.junit.Test;

public class LiquidadorTest {

    @Test
    public void probarLiquidacionEfectivo(){
        //DADO
        String resultadoEsperado="La liquidación generada es un documento digital. Saldo a liquidar: 520";
        //Creamos un objeto empleadoEfectivo
        Empleado empleadoEfectivo= new EmpleadoEfectivo("Martín","Martini","1122",500,60,40);
        //Creamos un Liquidador para el calculo
        Liquidador liquidadorEfectivo= new LiquidadorSueldoEmpleadoEfectivo();

        //CUANDO
        String resultadoObtenido= liquidadorEfectivo.liquidarSueldo(empleadoEfectivo);

        //ENTONCES
        Assert.assertEquals(resultadoEsperado,resultadoObtenido);
    }


    @Test
    public void probarLiquidacionContratado(){
        //DADO
        String restultadoEsperado = "La liquidación generada es un documento impreso. Saldo a liquidar: 840";
        //Crear objeto EmpleadoContrado y setear los atributos
        //Creamos un objeto empleadoContratado
        Empleado empleadoContratado= new EmpleadoContratado("Pompilia","Pompini","5566",120,7);
        //Creamos un Liquidador para el calculo
        Liquidador liquidadorContratado= new LiquidadorSueldoEmpleadoContratado();

        //CUANDO
        String resultadoContratado= liquidadorContratado.liquidarSueldo(empleadoContratado);

        //ENTONCES
        Assert.assertEquals(restultadoEsperado,resultadoContratado);
    }


    @Test
    public void probarNoPuedeCalcular(){
        //DADP
        String resultadoEsperado= "La liquidación no pudo ser realizada.";
        //Creamos un objeto empleadoContratado
        Empleado empleadoContratado= new EmpleadoContratado("Pompilia","Pompini","5566",120,7);
        //Creamos un Liquidador para el calculo
        Liquidador liquidadorEfectivo= new LiquidadorSueldoEmpleadoEfectivo();

        //CUANDO
        String resultado= liquidadorEfectivo.liquidarSueldo(empleadoContratado);

        //ENTONCES
        Assert.assertEquals(resultadoEsperado,resultado);
    }

}
