package com.example.demo.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.CheckOut;
import com.example.demo.modelo.ReservaHabitacion;
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
                Aggregation.match(Criteria.where("fecha_check_out").ne(null)),
                Aggregation.project()
                        .and("id_habitacion").as("id_habitacion")
                        .and("usuario").as("usuario")
                        .and("fecha_check_in").as("fecha_check_in")
                        .and("fecha_check_out").as("fecha_check_out")
                        .and("costo_reserva").as("costo_reserva")
                        .and("costo_consumos").as("costo_consumos")
                        .andExpression("costo_reserva + costo_consumos").as("ganancias_totales"),
                Aggregation.sort(Sort.Direction.ASC, "id_habitacion"));

        List<CheckOut> checkOuts = mongoTemplate.aggregate(aggregation, "reservas_habitaciones", CheckOut.class)
                .getMappedResults();

        model.addAttribute("checkOuts", checkOuts);

        return "checkOuts";
    }

    @GetMapping("/startCrearCheckOut")
    public String startCrearCheckOut(Model model) {

        model.addAttribute("checkOut", new CheckOut());

        return "crearCheckOutForm";
    }

    @PostMapping("/crearCheckOut")
    public String crearCheckOut(CheckOut checkOut) {

        // checkOutRepository.save(checkOut);

        return "redirect:/checkOuts";
    }

    @GetMapping("/checkOut/{id}/edit")
    public String mostrarFormularioActualizar(@PathVariable("id") String id, Model model) {

        ObjectId objectId = new ObjectId(id);

        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.findById(objectId).get();

        model.addAttribute("reservaHabitacion", reservaHabitacion);

        return "editarCheckOut";
    }

    @PostMapping("/checkOut/{id}/edit/save")
    public String actualizarCheckOut(@PathVariable("id") String id,
            @ModelAttribute ReservaHabitacion reservaHabitacion) {

        System.out.println(reservaHabitacion.getIdHabitacion());

        reservaHabitacionRepository.save(reservaHabitacion);

        return "redirect:/checkOuts";
    }

    @GetMapping("/checkOut/{id}/delete")
    public String eliminarCheckOut(@PathVariable("id") String id) {

        ObjectId objectId = new ObjectId(id);
        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.findById(objectId).get();
        reservaHabitacion.setFechaCheckOut(null);

        reservaHabitacionRepository.save(reservaHabitacion);

        return "redirect:/checkOuts";
    }

}
