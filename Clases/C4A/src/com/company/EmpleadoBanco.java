package com.company;

public abstract class EmpleadoBanco {
    //atributo
    protected EmpleadoBanco sigEmpleadoBanco;
    //GETTER
    public EmpleadoBanco getSigEmpleadoBanco() {
        return sigEmpleadoBanco;
    }
    //SETTER
    public void setSigEmpleadoBanco(EmpleadoBanco sigEmpleadoBanco) {
        this.sigEmpleadoBanco = sigEmpleadoBanco;
    }

    //metodo abstracto
    public abstract void procesarSolicitud(Integer monto);
}
