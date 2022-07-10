package com.example.clinica_dental_pi.controller;


import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Odontologo;
import com.example.clinica_dental_pi.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Integer id){
        Odontologo odontologo = odontologoService.buscar(id);
        if(odontologo !=null){
            return ResponseEntity.ok(odontologo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        odontologoService.eliminar(id);
        return ResponseEntity.ok().body("Eliminado");
    }


    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    @PutMapping
    public ResponseEntity<Odontologo> actulizar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizar(odontologo));
    }
}
