package com.example.C38S.repository;

import com.example.C38S.model.Torneo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TorneoRepository extends MongoRepository <Torneo,String> {
}
