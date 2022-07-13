package com.example.C38SMongoDB.controller;

import com.example.C38SMongoDB.model.Torneo;
import com.example.C38SMongoDB.service.TorneoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneos")
public class TorneoController {

    @Autowired
    private TorneoService torneoService;


    @Operation(summary = "Este endpoint permite agregar nuevos torneos")
    @PostMapping("/nuevo")
    private Torneo crearTorneo(@RequestBody Torneo torneo){
        return torneoService.agregar(torneo);
    }

    @GetMapping("/listar")
    private List<Torneo> obtenerTorneos(){
        return torneoService.getTorneos();
    }

}
