package com.example.C32S_mesa.service;

import com.example.C32S_mesa.model.Producto;
import com.example.C32S_mesa.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private IProductoRepository iProductoRespository;

    public ProductoService(IProductoRepository iProductoRespository) {
        this.iProductoRespository = iProductoRespository;
    }

    public Producto crearProducto(Producto producto){
        return iProductoRespository.save(producto);
    }

     public List<Producto> obtenerProductos(){
        return iProductoRespository.findAll();
    }

    public void eliminarProducto(Long id){
        iProductoRespository.deleteById(id);
    }

    public List<Producto> obtenerProductosConStock(){
        List<Producto> productosStock = new ArrayList<>();
        List<Producto> productosTodos = this.obtenerProductos();
        for (Producto producto:productosTodos) {
            if(producto.getCantidad() > 0){
                productosStock.add(producto);
            }
        }
        return productosStock;
    }

    public Producto obtenerProductoId(Long id){
        Producto producto = new Producto();
        List<Producto> productosTodos = this.obtenerProductos();
        for (Producto p:productosTodos) {
            if(p.getId() == id){
                producto = p;
            }
        }
        return producto;
    }


}
