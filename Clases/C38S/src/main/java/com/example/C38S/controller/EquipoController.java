package com.example.C38S.controller;


import com.example.C38S.model.EquipoLocal;
import com.example.C38S.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;


    @GetMapping
    public List<EquipoLocal> listar(){
        return equipoService.listar();
    }

    @PostMapping
    public EquipoLocal guardar(@RequestBody EquipoLocal equipo){
        return equipoService.guardar(equipo);
    }

}
