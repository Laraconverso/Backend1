package com.example.C38S.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "partidos1")
public class Partido {
    @Id
    private String id;
    private String estado;//(Calendario, Por comenzar, En vivo, Finalizado).
    private String resultado;

    @Field(name = "equipo_local")
    private Equipo equipoLocal;

    @Field(name = "equipo_visitante")
    private Equipo equipoVisitante;



    public Partido() {
    }

    public Partido(String id, String estado, String resultado, Equipo equipoLocal, Equipo equipoVisitante) {
        this.id = id;
        this.estado = estado;
        this.resultado = resultado;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
}
