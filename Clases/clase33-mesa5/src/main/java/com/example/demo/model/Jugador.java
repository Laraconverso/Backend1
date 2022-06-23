package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private int numero;
    private String puesto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Jugador(Long id, String nombre, int numero, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.puesto = puesto;
    }

    public Jugador(String nombre, int numero, String puesto) {
        this.nombre = nombre;
        this.numero = numero;
        this.puesto = puesto;
    }

    public Jugador() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
