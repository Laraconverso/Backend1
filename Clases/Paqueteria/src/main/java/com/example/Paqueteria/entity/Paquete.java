package com.example.Paqueteria.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "paquetes")
public class Paquete {

    @Id
    private String id;
    private String codigo;
    private String nombre;
    private String estado; // (por recoger, en camino, entregado).

    @Field(name = "destino")
    private Destino destino;

    public Paquete() {
    }

    public Paquete(String id, String codigo, String nombre, String estado, Destino destino) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.destino = destino;
    }

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public Destino getDestino() {
        return destino;
    }
}
