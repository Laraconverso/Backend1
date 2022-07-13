package com.example.C38SMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.scheduling.annotation.Scheduled;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "torneos")
public class Torneo {
    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 30)
    private String nombre;

    private String pais;

    public Torneo() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
