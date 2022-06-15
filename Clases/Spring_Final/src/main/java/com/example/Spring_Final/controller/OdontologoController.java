package com.example.Spring_Final.controller;

import com.example.Spring_Final.dao.impl.OdontologoDaoH2;
import com.example.Spring_Final.dao.impl.PacienteDaoH2;
import com.example.Spring_Final.model.Odontologo;
import com.example.Spring_Final.model.Paciente;
import com.example.Spring_Final.service.OdontologoService;
import com.example.Spring_Final.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService=new OdontologoService(new OdontologoDaoH2());

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(odontologoService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        //return pacienteService.actualizar(paciente);
        ResponseEntity<Odontologo> response;
        //Verificar si el ID es distinto de NULL y si el paciente existe
        if (odontologo.getId() != null && odontologoService.buscar(odontologo.getId()) != null) {
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response;
        odontologoService.eliminar(id);

        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos() {
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }


}

