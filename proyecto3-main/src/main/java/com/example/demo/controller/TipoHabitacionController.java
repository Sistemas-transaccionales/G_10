package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
                                new ArrayList<ObjectId>());

                habitacionRepository.save(habitacion);

                return "redirect:/tiposHabitaciones";
        }

        @GetMapping("/tipoHabitacion/{tipo}/edit")
        public String mostrarFormularioActualizar(@PathVariable("tipo") String tipo, Model model) {

                GroupOperation groupOperation = Aggregation.group("tipo.tipo")
                                .first("tipo.costo_por_noche").as("costo_por_noche")
                                .first("tipo.capacidad").as("capacidad")
                                .first("tipo.dotaciones").as("dotaciones")
                                .push("_id").as("habitaciones");

                Aggregation aggregation = Aggregation.newAggregation(groupOperation,
                                Aggregation.match(Criteria.where("_id").is(tipo)),
                                Aggregation.project().andInclude("dotaciones", "costo_por_noche", "capacidad",
                                                "habitaciones").and("_id").as("tipo"));

                List<TipoHabitacion> tiposHabitaciones = mongoTemplate
                                .aggregate(aggregation, "habitaciones", TipoHabitacion.class).getMappedResults();

                TipoHabitacion tipoHabitacion = tiposHabitaciones.get(0);

                model.addAttribute("tipoHabitacion", tipoHabitacion);

                return "editarTipoHabitacion";
        }

        @PostMapping("/tipoHabitacion/{tipo}/edit/save")
        public String actualizarTipoHabitacion(@PathVariable("tipo") String tipo,
                        @ModelAttribute("tipoHabitacion") TipoHabitacion tipoHabitacion) {

                tipoHabitacion.getDotaciones().removeIf(String::isEmpty);

                TipoHabitacionEmbedded tipoHabitacionEmbedded = new TipoHabitacionEmbedded(tipo,
                                tipoHabitacion.getCosto_por_noche(), tipoHabitacion.getCapacidad(),
                                tipoHabitacion.getDotaciones());

                List<Habitacion> habitaciones = habitacionRepository.findByTipo(tipoHabitacionEmbedded);

                for (Habitacion habitacion : habitaciones) {
                        habitacion.setTipo(tipoHabitacionEmbedded);
                        habitacionRepository.save(habitacion);
                }

                return "redirect:/tiposHabitaciones";
        }

        @GetMapping("/tipoHabitacion/{tipo}/delete")
        public String eliminarTipoHabitacion(@PathVariable("tipo") String tipo) {

                GroupOperation groupOperation = Aggregation.group("tipo.tipo")
                                .first("tipo.costo_por_noche").as("costo_por_noche")
                                .first("tipo.capacidad").as("capacidad")
                                .first("tipo.dotaciones").as("dotaciones")
                                .push("_id").as("habitaciones");

                Aggregation aggregation = Aggregation.newAggregation(groupOperation,
                                Aggregation.match(Criteria.where("_id").is(tipo)),
                                Aggregation.project().andInclude("dotaciones", "costo_por_noche", "capacidad",
                                                "habitaciones").and("_id").as("tipo"));

                List<TipoHabitacion> tiposHabitaciones = mongoTemplate
                                .aggregate(aggregation, "habitaciones", TipoHabitacion.class).getMappedResults();

                TipoHabitacion tipoHabitacionEliminar = tiposHabitaciones.get(0);

                TipoHabitacionEmbedded tipoHabitacionEmbedded = new TipoHabitacionEmbedded(
                                tipoHabitacionEliminar.getTipo(),
                                tipoHabitacionEliminar.getCosto_por_noche(), tipoHabitacionEliminar.getCapacidad(),
                                tipoHabitacionEliminar.getDotaciones());

                List<Habitacion> habitaciones = habitacionRepository.findByTipo(tipoHabitacionEmbedded);

                TipoHabitacionEmbedded tipoHabitacionNulo = new TipoHabitacionEmbedded("Nulo", 0, 0,
                                new ArrayList<String>());

                for (Habitacion habitacion : habitaciones) {
                        habitacion.setTipo(tipoHabitacionNulo);
                        habitacionRepository.save(habitacion);
                }

                return "redirect:/tiposHabitaciones";
        }

}
