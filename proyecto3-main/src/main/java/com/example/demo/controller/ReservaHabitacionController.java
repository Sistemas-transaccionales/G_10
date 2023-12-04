package com.example.demo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.ReservaHabitacion;
import com.example.demo.modelo.TipoHabitacion;
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

    @GetMapping("/startCrearReservaHabitacion")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("nuevaReservaHabitacion", new ReservaHabitacion());
        return "crearReservaHabitacionForm";
    }

    @PostMapping("/crearReservaHabitacion")
    public String crearReservaHabitacion(
            @ModelAttribute("nuevaReservaHabitacion") ReservaHabitacion reservaHabitacion) {

        Habitacion habitacion = habitacionRepository.findById(reservaHabitacion.getIdHabitacion()).get();

        // generar un nuevo ObjectId:
        reservaHabitacion.setId(new ObjectId());

        Usuario usuario = usuarioRepository.findByTipoDocAndNumDoc(reservaHabitacion.getUsuario().getTipoDoc(),
                reservaHabitacion.getUsuario().getNumDoc()).get();

        habitacion.addReserva(reservaHabitacion.getId());
        habitacionRepository.save(habitacion);

        usuario.addReservaHabitacion(reservaHabitacion.getId());
        usuarioRepository.save(usuario);

        reservaHabitacion.setCuentaAbierta(false);
        reservaHabitacion.setFechaCheckIn(null);
        reservaHabitacion.setFechaCheckOut(null);
        reservaHabitacion.setCostoConsumos(0);

        reservaHabitacionRepository.save(reservaHabitacion);

        return "redirect:/reservasHabitaciones";
    }

    @GetMapping("/reservaHabitacion/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable("id") String id, Model model) {
        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.findById(new ObjectId(id)).get();
        model.addAttribute("reservaHabitacion", reservaHabitacion);
        return "editarReservaHabitacion";
    }

    @PostMapping("/reservaHabitacion/{id}/edit/save")
    public String editarReservaHabitacion(@PathVariable String id,
            @ModelAttribute("reservaHabitacion") ReservaHabitacion reservaHabitacion) {

        ReservaHabitacion reservaHabitacionActual = reservaHabitacionRepository.findById(new ObjectId(id)).get();

        reservaHabitacionActual.setIdHabitacion(reservaHabitacion.getIdHabitacion());
        reservaHabitacionActual.setUsuario(reservaHabitacion.getUsuario());
        reservaHabitacionActual.setFechaInicio(reservaHabitacion.getFechaInicio());
        reservaHabitacionActual.setFechaFin(reservaHabitacion.getFechaFin());
        reservaHabitacionActual.setNumPersonas(reservaHabitacion.getNumPersonas());
        reservaHabitacionActual.setPlanConsumo(reservaHabitacion.getPlanConsumo());
        reservaHabitacionActual.setCostoReserva(reservaHabitacion.getCostoReserva());
        reservaHabitacionActual.setCostoReserva(reservaHabitacion.getCostoReserva());

        reservaHabitacionRepository.save(reservaHabitacionActual);

        return "redirect:/reservasHabitaciones";
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
