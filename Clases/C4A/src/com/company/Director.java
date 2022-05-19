package com.company;

public class Director extends EmpleadoBanco{
    @Override
    public void procesarSolicitud(Integer monto) {
        if(monto >= 60000 && monto <= 200000){
            System.out.println("Yo lo manejo. Soy Director.");
        }else if(this.getSigEmpleadoBanco()!=null){
            System.out.println("No puedo tratar esta solicitud, soy Director");
            this.getSigEmpleadoBanco().procesarSolicitud(monto);
        } else{
            System.out.println("No se puede otorgar el prestamo.");
        }
    }
}
