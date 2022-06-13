package com.example.Spring_Final.model;

public class Odontologo {

    //Atributos
    private int matricula;
    private String nombre;
    private String apellido;
    private int id;

    //Constructor
    public Odontologo(int matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(int id, int matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getters & Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Agrego To String para visualizar informacion

    @Override
    public String toString() {
        return "Odontologo{" + "id=" + id +
                ", matricula=" + matricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\''+
                '}';
    }
}
