package com.company;

public class Main {

    public static void main(String[] args) {
	// Crear los manejadores concretos
        EmpleadoBanco empleado1 = new EjectutivoCuenta();
        EmpleadoBanco empleado2 = new Director();
        EmpleadoBanco empleado3 = new Gerente();


        empleado1.setSigEmpleadoBanco(empleado2);
        empleado2.setSigEmpleadoBanco(empleado3);

        //Realizar una solicitud concreta
        empleado1.procesarSolicitud(70000);

    }
}
