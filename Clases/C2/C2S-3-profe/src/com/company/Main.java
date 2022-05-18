public class Main {

    public static void main(String[] args) {
        //Creamos un objeto empleadoEfectivo
	    Empleado empleadoEfectivo= new EmpleadoEfectivo("Martín","Martini","1122",400,60,40);
        //Creamos un Liquidador para el calculo
        Liquidador liquidadorEfectivo= new LiquidadorSueldoEmpleadoEfectivo();

        String resultadoEfectivo= liquidadorEfectivo.liquidarSueldo(empleadoEfectivo);
        System.out.println("Resultado Efectivo: "+resultadoEfectivo);


        //Creamos un objeto empleadoContratado
        Empleado empleadoContratado= new EmpleadoContratado("Pompilia","Pompini","5566",120,7);
        //Creamos un Liquidador para el calculo
        Liquidador liquidadorContratado= new LiquidadorSueldoEmpleadoContratado();

        String resultadoContratado= liquidadorContratado.liquidarSueldo(empleadoContratado);
        System.out.println("Resultado Contratado: "+resultadoContratado);
    }
}
