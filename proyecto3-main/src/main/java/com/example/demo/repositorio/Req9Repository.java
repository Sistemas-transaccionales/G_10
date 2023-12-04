package com.example.demo.repositorio;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.modelo.Requerimiento9;

public interface Req9Repository extends MongoRepository<Requerimiento9, ObjectId> {

    // Puedes agregar consultas personalizadas si es necesario

}