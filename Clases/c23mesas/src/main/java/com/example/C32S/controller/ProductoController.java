package com.example.C32S.controller;

import com.example.C32S.model.Producto;
import com.example.C32S.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {

    //Se inyecta la dependencia
    @Autowired
    private ProductoService productoService;


    @PostMapping("/productos")
    public Producto guardar(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    //arreglar
    @PutMapping("/productos")
    public Producto restarStock(@RequestBody Long id, Integer cantidad){
        return productoService.restarStock(id,cantidad);
    }


    @GetMapping("/{id}")
    public Optional<Producto> buscarPorId(@PathVariable Long id){
        return productoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id){
        productoService.eliminarPorId(id);
    }

    @GetMapping("/productosConStock")
    public List<Producto> obtenerProductosConStock(){
        return productoService.obtenerProductosConStock();
    }



}
