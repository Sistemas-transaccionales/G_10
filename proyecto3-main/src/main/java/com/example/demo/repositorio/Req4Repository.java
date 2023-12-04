package com.example.demo.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.modelo.Requerimiento4;

public interface Req4Repository extends MongoRepository<Requerimiento4, ObjectId> {



}