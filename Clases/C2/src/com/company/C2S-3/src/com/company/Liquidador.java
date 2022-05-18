public abstract class Liquidador {

    //Metodo abstracto (se debe sobreescribir en la sub-clase)
    public abstract String liquidarSueldo(Empleado empleado);//Método plantilla (Template Method)


    //Metodo concreto
    public String depositarSueldo(Empleado empleado){
        return "Sueldo depositado en la cuenta " + empleado.getNumeroDeCuenta();
    }

}
