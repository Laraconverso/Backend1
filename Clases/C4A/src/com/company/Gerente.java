package com.company;

public class Gerente extends EmpleadoBanco{
    @Override
    public void procesarSolicitud(Integer monto) {
        if(monto > 200000){
            System.out.println("Yo me encargo. Soy gerente");
        } else if(this.getSigEmpleadoBanco() != null){
            System.out.println("No hay mas empleados.");
        }
    }
}
