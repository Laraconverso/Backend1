package com.example.clinicadental.clinica.controller;

import com.example.clinicadental.clinica.dao.impl.PacienteDaoH2;
import com.example.clinicadental.clinica.model.Odontologo;
import com.example.clinicadental.clinica.model.Paciente;
import com.example.clinicadental.clinica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id){
        Paciente paciente= pacienteService.buscar(id);
        if(paciente != null){
            return ResponseEntity.ok(paciente);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        if(pacienteService.buscar(id) != null){
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.OK).body("eliminado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente){

        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }

    @PutMapping
    public ResponseEntity<Paciente> actulizar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.actualizar(paciente));
    }
}
