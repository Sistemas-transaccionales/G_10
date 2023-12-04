package main.java.com.example.demo.controller;

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

import com.example.demo.modelo.CheckIn;
import com.example.demo.modelo.ReservaHabitacion;
import com.example.demo.repositorio.CheckInRepository;
import com.example.demo.repositorio.ReservaHabitacionRepository;

@Controller
public class CheckInController {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/checkIns")
    public String checkIns(Model model) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("fecha_check_out").ne(null)),
                Aggregation.project()
                        .and("id_habitacion").as("id_habitacion")
                        .and("usuario").as("usuario")
                        .and("fecha_check_in").as("fecha_check_in")
                        .and("fecha_check_out").as("fecha_check_out")
                        .and("costo_reserva").as("costo_reserva"),
                Aggregation.sort(Sort.Direction.ASC, "id_habitacion"));

        List<CheckIn> checkIns = mongoTemplate.aggregate(aggregation, "reservas_habitaciones", CheckIn.class)
                .getMappedResults();

        model.addAttribute("checkIns", checkIns);

        return "checkIns";
    }

    @GetMapping("/startCrearCheckIn")
    public String startCrearCheckIn(Model model) {

        model.addAttribute("checkIn", new CheckIn());

        return "crearCheckInForm";
    }

    @PostMapping("/crearCheckIn")
    public String crearCheckIn(CheckIn checkIn) {

        // checkInRepository.save(checkIn);

        return "redirect:/checkIns";
    }

    @GetMapping("/checkIn/{id}/edit")
    public String mostrarFormularioActualizar(@PathVariable("id") String id, Model model) {

        ObjectId objectId = new ObjectId(id);

        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.findById(objectId).get();

        model.addAttribute("reservaHabitacion", reservaHabitacion);

        return "editarCheckIn";
    }

    @PostMapping("/checkIn/{id}/edit/save")
    public String actualizarCheckIn(@PathVariable("id") String id,
            @ModelAttribute ReservaHabitacion reservaHabitacion) {

        System.out.println(reservaHabitacion.getIdHabitacion());

        reservaHabitacionRepository.save(reservaHabitacion);

        return "redirect:/checkIns";
    }

    @GetMapping("/checkIn/{id}/delete")
    public String eliminarCheckIn(@PathVariable("id") String id) {

        ObjectId objectId = new ObjectId(id);
        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.findById(objectId).get();
        reservaHabitacion.setFechaCheckIn(null);

        reservaHabitacionRepository.save(reservaHabitacion);

        return "redirect:/checkIns";
    }

}
