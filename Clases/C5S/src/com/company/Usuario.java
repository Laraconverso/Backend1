package com.company;

public class Usuario {
    private String ID;
    private String tipoUsuario;

    public Usuario(String ID, String tipoUsuario) {
        this.ID = ID;
        this.tipoUsuario = tipoUsuario;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
