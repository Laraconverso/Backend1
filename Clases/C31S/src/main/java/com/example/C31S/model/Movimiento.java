package com.example.C31S.model;

import javax.persistence.*;

@Entity
@Table(name = "tabla_movimientos")
public class Movimiento {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String descripcion;

    private Double monto;


    public Movimiento() {
    }

    public Movimiento(Long id, String descripcion, Double monto) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
