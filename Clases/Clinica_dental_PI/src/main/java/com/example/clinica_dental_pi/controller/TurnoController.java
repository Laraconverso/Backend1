package com.example.clinica_dental_pi.controller;


import com.example.clinica_dental_pi.exceptions.BadRequestException;
import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Turno;
import com.example.clinica_dental_pi.service.OdontologoService;
import com.example.clinica_dental_pi.service.PacienteService;
import com.example.clinica_dental_pi.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

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
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException{
        ResponseEntity<String> response;
//        if (turnoService.buscar(id) != null){
//            turnoService.eliminarTurno(id);
//            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
//        }else{
//            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return response;
        turnoService.eliminarTurno(id);
        return response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
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
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno)throws BadRequestException {
//        ResponseEntity<Turno> response;
//        if(pacienteService.buscar(turno.getPaciente().getId()) != null && odontologoService.buscar(turno.getOdontologo().getId()) != null){
//            response = ResponseEntity.ok(turnoService.registrarTurno(turno));
//        }else{
//            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//        return response;

        return ResponseEntity.ok(turnoService.registrarTurno(turno));
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> tratarErrorNotFound(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()+ " -GLOBAL");
    }

}