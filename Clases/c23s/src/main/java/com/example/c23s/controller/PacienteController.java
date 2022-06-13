package com.example.c23s.controller;


import com.example.c23s.model.Paciente;
import com.example.c23s.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PacienteController {


    private PacienteService pacienteService= new PacienteService();

    @GetMapping()
    public String getPaciente(Model model){
        Paciente paciente= pacienteService.buscarPorEmail("juan@hotmail.com");

        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());

        //return "Hola Paciente: "+paciente.getNombre();
        return "index";
    }


}
