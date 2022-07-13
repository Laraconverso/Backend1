package com.example.C38SMongoDB.controller;

import com.example.C38SMongoDB.model.Partido;
import com.example.C38SMongoDB.service.PartidoService;
import com.example.C38SMongoDB.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public Partido registrar(@RequestBody Partido partido){
        return partidoService.agregar(partido);
    }

    @GetMapping
    public List<Partido> listar(){
        return partidoService.listar();
    }

    @GetMapping("/en-vivo")
    public List<Partido> partidosEnVivo(){
        return partidoService.partidosEnVivo();
    }

}
