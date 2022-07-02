package com.example.C38S.repository;

import com.example.C38S.model.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PartidoRepository extends MongoRepository<Partido,String> {

    List<Partido> findAllByEstado(String estado);

}
