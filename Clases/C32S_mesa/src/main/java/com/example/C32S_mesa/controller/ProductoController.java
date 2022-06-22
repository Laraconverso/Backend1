package com.example.C32S_mesa.controller;

import com.example.C32S_mesa.model.Producto;
import com.example.C32S_mesa.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear-producto")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Producto>> buscarProductos(){
        return ResponseEntity.ok(productoService.obtenerProductos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

    @GetMapping("/buscar-stock")
    public ResponseEntity<List<Producto>> buscarProductosConStock(){
        return ResponseEntity.ok(productoService.obtenerProductosConStock());
    }

    @GetMapping("/buscar-id/{id}")
    public ResponseEntity<Producto> buscarProductoId(@PathVariable Long id){
        return ResponseEntity.ok(productoService.obtenerProductoId(id));
    }

}
