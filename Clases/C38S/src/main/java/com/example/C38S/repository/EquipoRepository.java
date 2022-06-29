package com.example.C38S.repository;

import com.example.C38S.model.EquipoLocal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipoRepository extends MongoRepository<EquipoLocal, String> {
}
