package com.example.clinicadental.clinica.controller;

import com.example.clinicadental.clinica.dao.impl.PacienteDaoH2;
import com.example.clinicadental.clinica.model.Paciente;
import com.example.clinicadental.clinica.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping("/{id}")
    public Paciente buscar(@PathVariable Integer id){
        return pacienteService.buscar(id);

    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        pacienteService.eliminar(id);
    }

    @GetMapping
    public List<Paciente> buscarTodos(){
        return pacienteService.buscarTodos();
    }

    @PostMapping
    public Paciente guardar(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }

    @PutMapping
    public Paciente actulizar(@RequestBody Paciente paciente){
        return pacienteService.actualizar(paciente);
    }
}
