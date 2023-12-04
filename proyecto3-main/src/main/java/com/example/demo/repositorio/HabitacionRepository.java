package com.example.demo.repositorio;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.TipoHabitacionEmbedded;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {

    List<Habitacion> findByTipoTipo(String tipo);

    List<Habitacion> findByTipo(TipoHabitacionEmbedded tipo);
}