package com.example.Spring_Final.controller;

import com.example.Spring_Final.dao.impl.OdontologoDaoH2;
import com.example.Spring_Final.dao.impl.PacienteDaoH2;
import com.example.Spring_Final.dao.impl.TurnoRepository;
import com.example.Spring_Final.model.Turno;
import com.example.Spring_Final.service.OdontologoService;
import com.example.Spring_Final.service.PacienteService;
import com.example.Spring_Final.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService = new TurnoService(new TurnoRepository());
    private PacienteService pacienteService = new PacienteService((new PacienteDaoH2()));
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Integer id){
        Turno turno = turnoService.buscar(id);
        if(turno !=null){
            return ResponseEntity.ok(turno);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response;
        if (turnoService.buscar(id) != null){
            turnoService.eliminarTurno(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;

    }

    @PutMapping
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno){
        ResponseEntity<Turno> response;
        if(turno.getId() != null && turnoService.buscar(turno.getId()) != null){
            response =  ResponseEntity.ok(turnoService.actualizar(turno));
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
        ResponseEntity<Turno> response;
        if(pacienteService.buscar(turno.getPaciente().getId()) != null && odontologoService.buscar(turno.getOdontologo().getId()) != null){
            response = ResponseEntity.ok(turnoService.registrarTurno(turno));
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

}