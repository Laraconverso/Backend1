package com.example.Spring_Final.controller;

import com.example.Spring_Final.dao.impl.TurnoRepository;
import com.example.Spring_Final.model.Paciente;
import com.example.Spring_Final.model.Turno;
import com.example.Spring_Final.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService = new TurnoService(new TurnoRepository());

    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(Turno turno){
        return ResponseEntity.ok(turnoService.registrarTurno(turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response;
        turnoService.eliminarTurno(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(turnoService.buscar(id));
    }

    @PutMapping
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
        //return pacienteService.actualizar(paciente);
        ResponseEntity<Turno> response;
        //Verificar si el ID es distinto de NULL y si el turno existe
        if (turno.getId() != null && turnoService.buscar(turno.getId()) != null) {
            response = ResponseEntity.ok(turnoService.actualizar(turno));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}


