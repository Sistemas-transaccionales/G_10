package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.modelo.CheckOut;
import com.example.demo.repositorio.CheckOutRepository;
import com.example.demo.repositorio.ReservaHabitacionRepository;

@Controller
public class CheckOutController {

    @Autowired
    private CheckOutRepository checkOutRepository;

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/checkOuts")
    public String checkOuts(Model model) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project()
                        .and("id_habitacion").as("id_habitacion")
                        .and("usuario").as("usuario")
                        .and("fecha_check_in").as("fecha_check_in")
                        .and("fecha_check_out").as("fecha_check_out")
                        .and("costo_reserva").as("costo_reserva")
                        .and("costo_consumos").as("costo_consumos")
                        .andExpression("costo_reserva + costo_consumos").as("ganancias_totales"));

        List<CheckOut> checkOuts = mongoTemplate.aggregate(aggregation, "reservas_habitaciones", CheckOut.class)
                .getMappedResults();

        model.addAttribute("checkOuts", checkOuts);

        return "checkOuts";
    }

}
