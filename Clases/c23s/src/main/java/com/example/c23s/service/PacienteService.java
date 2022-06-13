package com.example.c23s.service;


import com.example.c23s.model.Paciente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacienteService {

    List<Paciente> listPacientes= new ArrayList<>();

    //Constructor
    public PacienteService() {
        listPacientes= Arrays.asList(new Paciente(1L,"Juan","Perez","juan@hotmail.com"),
                new Paciente(2L,"Jose","Garcia","jose@hotmail.com"));
    }


    public List<Paciente> getPacientes(){
        return listPacientes;
    }

    public Paciente buscarPorEmail(String email){
        Paciente pacienteRetorno= null;
        for (Paciente pacienteAux : listPacientes){
            if (pacienteAux.getEmail().equals(email)){
                pacienteRetorno= pacienteAux;
            }
        }
        return pacienteRetorno;
    }

}
