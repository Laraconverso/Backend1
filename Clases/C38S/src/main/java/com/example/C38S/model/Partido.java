package com.example.C38S.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "partidos")
public class Partido {

    @Id
    private String id;
    private String estado;
    private int resultado;
    @Field(name="equipo")
    private EquipoLocal equipoLocal;

    public Partido() {
    }

    public Partido(String id, String estado, int resultado, EquipoLocal equipoLocal) {
        this.id = id;
        this.estado = estado;
        this.resultado = resultado;
        this.equipoLocal = equipoLocal;
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

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public EquipoLocal getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(EquipoLocal equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
}
