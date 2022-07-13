package com.example.C38SMongoDB.repository;

import com.example.C38SMongoDB.model.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartidoRepository extends MongoRepository<Partido,String> {

    List<Partido> findAllByEstado(String estado);
}
