package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.modelo.TipoHabitacion;
import com.example.demo.repositorio.HabitacionRepository;
import com.example.demo.repositorio.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {

        @Autowired
        private TipoHabitacionRepository tipoHabitacionRepository;

        @Autowired
        private HabitacionRepository habitacionRepository;

        @Autowired
        private MongoTemplate mongoTemplate;

        @GetMapping("/tiposHabitaciones")
        public String getTipoHabitaciones(Model model) {

                GroupOperation groupOperation = Aggregation.group("tipo.tipo")
                                .first("tipo.costo_por_noche").as("costo_por_noche")
                                .first("tipo.capacidad").as("capacidad")
                                .first("tipo.dotaciones").as("dotaciones")
                                .push("_id").as("habitaciones");

                ProjectionOperation projectOperation = Aggregation.project()
                                .andExclude("_id")
                                .andInclude("tipo", "dotaciones", "costo_por_noche", "capacidad", "habitaciones");

                Aggregation aggregation = Aggregation.newAggregation(groupOperation, projectOperation);

                List<TipoHabitacion> tiposHabitacion = mongoTemplate
                                .aggregate(aggregation, "tipos_habitaciones", TipoHabitacion.class).getMappedResults();
                model.addAttribute("tiposHabitaciones", tiposHabitacion);

                return "resultadosTiposHabitaciones";
        }

}
