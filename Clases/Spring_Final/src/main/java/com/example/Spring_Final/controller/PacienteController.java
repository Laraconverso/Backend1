package com.example.Spring_Final.controller;


import com.example.Spring_Final.dao.impl.PacienteDaoH2;
import com.example.Spring_Final.model.Paciente;
import com.example.Spring_Final.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PacienteController {

    private PacienteService pacienteService= new PacienteService(new PacienteDaoH2());

    @GetMapping
    public List<Paciente> buscarTodos(){
        return pacienteService.buscarTodos();
    }

    @PostMapping
    public Paciente registrar(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response;
        
        pacienteService.actualizar(paciente);
        response = ResponseEntity.ok(paciente);
        return response;
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable int id){
        return pacienteService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public Paciente eliminar(@PathVariable int id){
        return pacienteService.buscar(id);
    }


//    @GetMapping()
//    public String getPaciente(Model model){
//        Paciente paciente= pacienteService.buscarPorEmail("juan@hotmail.com");
//
//        model.addAttribute("nombre",paciente.getNombre());
//        model.addAttribute("apellido",paciente.getApellido());
//
//        //return "Hola Paciente: "+paciente.getNombre();
//        return "index";
//    }
    /*private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Paciente> buscar(@PathVariable int id){
        Paciente paciente = pacienteService.buscar(id);
        return ResponseEntity.ok(paciente);
    }*/


}
