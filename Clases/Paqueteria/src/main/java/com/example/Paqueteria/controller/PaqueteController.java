package com.example.Paqueteria.controller;

import com.example.Paqueteria.entity.Paquete;
import com.example.Paqueteria.service.PaqueteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteService paqueteService;

    @Operation(summary = "Se guarda un paquete")
    @PostMapping
    public Paquete guardar(@RequestBody Paquete paquete){
        return paqueteService.guardar(paquete);
    }

    @Operation(summary = "Enlista un paquete")
    @GetMapping
    public List<Paquete> listar(){
        return paqueteService.listar();
    }

    @Operation(summary = "Enlista paquetes en estado en camino")
    @GetMapping("/en_camino")
    public List<Paquete> listarEnCamino(){
        return paqueteService.listarEnCamino();
    }

    @Operation(summary = "Enlista paquetes en estado entregado")
    @GetMapping("/entregado")
    public List<Paquete> listarEntregado(){
        return paqueteService.listarEntregado();
    }

}
