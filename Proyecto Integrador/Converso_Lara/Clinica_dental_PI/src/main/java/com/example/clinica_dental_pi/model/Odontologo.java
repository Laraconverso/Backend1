package com.example.clinica_dental_pi.model;

import javax.persistence.*;

@Entity
@Table(name = "odontologos")
public class Odontologo {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_secuencia")
    private Integer id;
    private int matricula;
    private String nombre;
    private String apellido;


    public Odontologo(){}

    //Constructor
    public Odontologo(int matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(Integer id, int matricula, String nombre, String apellido) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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