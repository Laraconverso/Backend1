package com.example.C38SMongoDB.repository;

import com.example.C38SMongoDB.model.Torneo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TorneoRepository extends MongoRepository<Torneo,Integer> {
}
