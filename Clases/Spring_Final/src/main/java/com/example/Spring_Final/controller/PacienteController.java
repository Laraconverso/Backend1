package com.example.Spring_Final.controller;


import com.example.Spring_Final.dao.impl.PacienteDaoH2;
import com.example.Spring_Final.model.Paciente;
import com.example.Spring_Final.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        //return pacienteService.actualizar(paciente);
        ResponseEntity<Paciente> response;
        //Verificar si el ID es distinto de NULL y si el paciente existe
        if (paciente.getId() != null && pacienteService.buscar(paciente.getId()) != null) {
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response;
        pacienteService.eliminar(id);

        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteService.buscar(id));
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