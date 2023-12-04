package com.example.demo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.ReservaHabitacion;
import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.UsuarioEmbedded;
import com.example.demo.repositorio.HabitacionRepository;
import com.example.demo.repositorio.ReservaHabitacionRepository;
import com.example.demo.repositorio.UsuarioRepository;

@Controller
public class ReservaHabitacionController {

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/reservasHabitaciones")
    public String getReservasHabitaciones(Model model) {
        model.addAttribute("reservasHabitaciones", reservaHabitacionRepository.findAll());
        return "reservasHabitaciones";
    }

    @GetMapping("/reservaHabitacion/{id}/delete")
    public String eliminarReservaHabitacion(@PathVariable String id) {

        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.findById(new ObjectId(id)).get();

        UsuarioEmbedded usuario = reservaHabitacion.getUsuario();

        Usuario usuarioActual = usuarioRepository.findByTipoDocAndNumDoc(usuario.getTipoDoc(), usuario.getNumDoc())
                .get();

        usuarioActual.getReservasHabitaciones().remove(reservaHabitacion.getId());
        usuarioRepository.save(usuarioActual);

        Habitacion habitacion = habitacionRepository.findById(reservaHabitacion.getIdHabitacion()).get();
        habitacion.getReservas().remove(reservaHabitacion.getId());
        habitacionRepository.save(habitacion);

        reservaHabitacionRepository.deleteById(new ObjectId(id));

        return "redirect:/reservasHabitaciones";
    }

}
