package com.example.C38S.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "torneos1")
public class Torneo {
    @Id
    private String id;
    private String nombre;
    private String pais;

    /*@Field(name = "equipo_local")
    private Equipo equipoLocal;

    @Field(name = "equipo_visitante")
    private Equipo equipoVisitante;  */

    public Torneo() {
    }

    public Torneo(String id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
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
}
