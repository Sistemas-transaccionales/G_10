package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.ReservaHabitacion;
import com.example.demo.modelo.TipoHabitacion;
import com.example.demo.modelo.TipoHabitacionEmbedded;
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
                                .andInclude("dotaciones", "costo_por_noche", "capacidad", "habitaciones").and("_id")
                                .as("tipo");

                Aggregation aggregation = Aggregation.newAggregation(groupOperation, projectOperation);

                List<TipoHabitacion> tiposHabitacion = mongoTemplate
                                .aggregate(aggregation, "habitaciones", TipoHabitacion.class).getMappedResults();

                model.addAttribute("tiposHabitaciones", tiposHabitacion);

                return "resultadosTiposHabitaciones";
        }

        @GetMapping("/startCrearTipoHabitacion")
        public String mostrarFormularioCrear(Model model) {
                model.addAttribute("nuevoTipoHabitacion", new TipoHabitacion());
                return "crearTipoHabitacionForm";
        }

        @PostMapping("/crearTipoHabitacion")
        public String crearTipoHabitacion(@ModelAttribute("nuevoTipoHabitacion") TipoHabitacion nuevoTipoHabitacion) {

                nuevoTipoHabitacion.getDotaciones().removeIf(String::isEmpty);

                Habitacion habitacion = new Habitacion(nuevoTipoHabitacion.getHabitaciones().get(0),
                                new TipoHabitacionEmbedded(nuevoTipoHabitacion.getTipo(),
                                                nuevoTipoHabitacion.getCosto_por_noche(),
                                                nuevoTipoHabitacion.getCapacidad(),
                                                nuevoTipoHabitacion.getDotaciones()),
                                new ArrayList<ReservaHabitacion>());

                habitacionRepository.save(habitacion);

                return "redirect:/tiposHabitaciones";
        }

        @GetMapping("/startActualizarTipoHabitacion")
        public String mostrarFormularioActualizar(Model model) {
                model.addAttribute("tipoHabitacion", new TipoHabitacion());
                return "actualizarTipoHabitacionForm";
        }

        @PostMapping("/actualizarTipoHabitacion")
        public String actualizarTipoHabitacion(@ModelAttribute("tipoHabitacion") TipoHabitacion tipoHabitacion) {

                tipoHabitacion.getDotaciones().removeIf(String::isEmpty);

                List<Habitacion> habitaciones = habitacionRepository
                                .findByTipoTipo(tipoHabitacion.getTipo());

                TipoHabitacionEmbedded tipoHabitacionEmbedded = new TipoHabitacionEmbedded(tipoHabitacion.getTipo(),
                                tipoHabitacion.getCosto_por_noche(), tipoHabitacion.getCapacidad(),
                                tipoHabitacion.getDotaciones());

                for (Habitacion habitacion : habitaciones) {
                        habitacion.setTipo(tipoHabitacionEmbedded);
                        habitacionRepository.save(habitacion);
                }

                return "redirect:/tiposHabitaciones";
        }

}
