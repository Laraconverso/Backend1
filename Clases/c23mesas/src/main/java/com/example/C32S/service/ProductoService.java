package com.example.C32S.service;

import com.example.C32S.model.Producto;
import com.example.C32S.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductoService {

    private IProductoRepository iProductoRepository;


    //Se inyecta la dependencia en el constructor
    public ProductoService(IProductoRepository iProductoRepository) {
        this.iProductoRepository = iProductoRepository;
    }


    public Producto crearProducto(Producto producto){
        //PERSISTE un Producto en la BD
        return iProductoRepository.save(producto);
    }


    public List<Producto> obtenerProductos(){
        //OBTIENE todos los productos desde la BD
        return iProductoRepository.findAll();
    }

    public Producto restarStock(Long id, Integer cantidad){
        List<Producto> productos = obtenerProductos();
        for (Producto p : productos
             ) {
            if(p.getId()==id){
                p.setCantidad(p.getCantidad()- cantidad);
                return iProductoRepository.save(p);
            }
        }
        return null;
    }

    public Optional<Producto> buscarPorId(Long id){
        return iProductoRepository.findById(id);
    }

    public void eliminarPorId(Long id){
        iProductoRepository.deleteById(id);
    }

    public List<Producto> obtenerProductosConStock(){
        List<Producto> productos = obtenerProductos();
        List<Producto> productosConStock = new ArrayList<>();
        for (Producto p : productos) {
            if(p.getCantidad()>0){
                productosConStock.add(p);
            }
        }
        return productosConStock;
    }









}
