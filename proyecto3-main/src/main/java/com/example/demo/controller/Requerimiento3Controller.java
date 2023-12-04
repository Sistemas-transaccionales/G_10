package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Requerimiento3;
import com.example.demo.repositorio.Requerimiento3Repository;

@Controller
public class Requerimiento3Controller {

        @Autowired
        private Requerimiento3Repository requerimiento3Repository;

        @Autowired
        private MongoTemplate mongoTemplate;

        @GetMapping("/requerimiento3Form")
        public String requerimiento3Form() {
                return "requerimiento3Form";
        }

        @PostMapping("/requerimiento3")
        public String requerimiento5(@RequestParam("numDoc") int numDoc, @RequestParam("tipoDoc") String tipoDoc,
                        @RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin,
                        Model model) {

                LocalDate fechaInicioLocal = LocalDate.parse(fechaInicio);
                LocalDate fechaFinLocal = LocalDate.parse(fechaFin);

                Aggregation aggregation = Aggregation.newAggregation(
                                Aggregation.match(Criteria.where("usuario.tipo_doc").is(tipoDoc)
                                                .and("usuario.num_doc").is(numDoc)
                                                .and("fecha").gte(fechaInicioLocal).lte(fechaFinLocal)),
                                Aggregation.lookup("servicios", "id_servicio", "_id", "info_servicio"),
                                Aggregation.unwind("$info_servicio"),
                                Aggregation.project().andExpression("usuario.tipo_doc").as("tipo_doc")
                                                .andExpression("usuario.num_doc").as("num_doc")
                                                .and("fecha").as("fecha")
                                                .and("costo").as("costo")
                                                .andExpression("info_servicio.nombre").as("nombre_servicio")
                                                .and("id_servicio").as("id_servicio"));

                List<Requerimiento3> consumosDeUsuario = mongoTemplate
                                .aggregate(aggregation, "reservas_servicios", Requerimiento3.class).getMappedResults();

                model.addAttribute("consumos_usuario", consumosDeUsuario);
                return "requerimiento3";
        }

}
