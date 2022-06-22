package com.example.C32S_mesa.repository;

import com.example.C32S_mesa.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
