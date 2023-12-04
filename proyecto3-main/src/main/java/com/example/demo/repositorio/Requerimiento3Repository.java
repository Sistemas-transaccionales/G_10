package com.example.demo.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.Requerimiento3;

public interface Requerimiento3Repository extends MongoRepository<Requerimiento3, ObjectId> {

}
