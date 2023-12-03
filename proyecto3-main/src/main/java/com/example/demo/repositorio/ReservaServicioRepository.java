package com.example.demo.repositorio;

import com.example.demo.modelo.ReservaServicio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaServicioRepository extends MongoRepository<ReservaServicio, String> {
}