public class LiquidadorSueldoEmpleadoEfectivo extends Liquidador {

    @Override
    public String liquidarSueldo(Empleado empleado) {
        String mensaje="La liquidación no pudo ser realizada.";
        if (empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo empleadoEfectivo= (EmpleadoEfectivo) empleado;
            int sueldo= empleadoEfectivo.getSueldoBase() + empleadoEfectivo.getBonos() - empleadoEfectivo.getDescuentos();
            mensaje= "La liquidación generada es un documento digital. Saldo a liquidar: "+sueldo;
        }
        return mensaje;
    }
}
