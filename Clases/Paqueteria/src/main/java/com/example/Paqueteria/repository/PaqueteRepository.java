package com.example.Paqueteria.repository;

import com.example.Paqueteria.entity.Paquete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaqueteRepository extends MongoRepository<Paquete, String> {

    List<Paquete> findAllByEstado(String estado);
}
