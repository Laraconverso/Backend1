package com.example.Spring_Final.controller;


import com.example.Spring_Final.dao.impl.PacienteDaoH2;
import com.example.Spring_Final.model.Paciente;
import com.example.Spring_Final.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class PacienteController {

    private PacienteService pacienteService= new PacienteService(new PacienteDaoH2());

    @GetMapping
    public List<Paciente> buscarTodosPacientes(){
        return pacienteService.buscarTodos();
    }

    @GetMapping
    public Paciente registrar(Paciente paciente){
        return pacienteService.guardar(paciente);
    }

    @PutMapping
    public Paciente actualizar(Paciente paciente){
        return pacienteService.actualizar(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(int id){
        return pacienteService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public Paciente eliminarPorId(@PathVariable int id){
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
