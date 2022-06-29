package com.example.C38S.controller;


import com.example.C38S.model.Partido;
import com.example.C38S.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> listar(){
        return partidoService.listar();
    }

    @PostMapping
    private Partido guardar(@RequestBody Partido partido){
        return partidoService.guardar(partido);
    }
}
