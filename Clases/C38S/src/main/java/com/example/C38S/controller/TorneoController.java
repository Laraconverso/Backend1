package com.example.C38S.controller;

import com.example.C38S.model.Torneo;
import com.example.C38S.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneos")
public class TorneoController {

    //Inyecto la dependencia
    @Autowired
    private TorneoService torneoService;


    @GetMapping("/listar")
    private List<Torneo> listar(){
        return torneoService.listarTorneos();
    }

    @PostMapping("/nuevo")
    private Torneo crear(@RequestBody Torneo torneo){
        return torneoService.agregarTorneo(torneo);
    }

}
