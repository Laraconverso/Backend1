public class LiquidadorSueldoEmpleadoContratado extends Liquidador {

    @Override
    public String liquidarSueldo(Empleado empleado) {

        EmpleadoContratado empleadoContratado= (EmpleadoContratado) empleado;
        int sueldo= empleadoContratado.getHorasTrabajadas() * empleadoContratado.getValorHora();
        String mensaje= "La liquidación generada es un documento impreso. Saldo a liquidar: "+sueldo;

        return mensaje;

        
    }
}
