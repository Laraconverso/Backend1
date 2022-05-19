package com.company;

public class EjectutivoCuenta extends EmpleadoBanco{
    @Override
    public void procesarSolicitud(Integer monto) {
        if(monto < 60000){
            System.out.println("Yo me encargo de gestionarlo. Soy Ejecutivo cuenta");
        } else if(this.getSigEmpleadoBanco()!=null){
            System.out.println("No puedo tratar esta solicitud, soy Ejecutivo de cuenta");
            this.getSigEmpleadoBanco().procesarSolicitud(monto);
        } else{
            System.out.println("No se puede otorgar el prestamo.");
        }
    }
}
