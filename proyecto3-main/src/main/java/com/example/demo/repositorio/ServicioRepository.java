package com.example.demo.repositorio;

import com.example.demo.modelo.Servicio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicioRepository extends MongoRepository<Servicio, String> {
}