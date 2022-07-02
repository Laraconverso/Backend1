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


    @PostMapping
    public Partido crear(@RequestBody Partido partido){
        return partidoService.crearPartido(partido);
    }

    @GetMapping()
    public List<Partido> listarTodos(){
        return partidoService.obtenerTodos();
    }

    @GetMapping("/en-vivo")
    public List<Partido> buscarPorEstado(){
        return partidoService.obtenerPartidosEnVivo();
    }

}
