package uniandes.edu.co.proyecto.controller.servicios_controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.ReservaServicio;
import uniandes.edu.co.proyecto.repository.HabitacionRepository;
import uniandes.edu.co.proyecto.repository.servicios_repository.ReservaServicioRepository;
import uniandes.edu.co.proyecto.repository.servicios_repository.ServicioRepository;

@Controller
public class ReservaServicioController {

    @Autowired
    private ReservaServicioRepository reservaServicioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/reservas_servicio")
    public String reservasServicio(Model model) {
        model.addAttribute("reservas_servicio", reservaServicioRepository.listarReservasServicio());
        return "reservas_servicio";
    }

    @GetMapping("/reservas_servicio/new")
    public String reservasServicioForm(Model model) {
        model.addAttribute("reserva_servicio", new ReservaServicio());
        model.addAttribute("habitaciones", habitacionRepository.listarHabitaciones());
        model.addAttribute("servicios", servicioRepository.listarServicios());
        return "reserva_servicio_nuevo";
    }

    @PostMapping("/reservas_servicio/new/save")
    public String reservasServicioGuardar(@ModelAttribute("id_habitacion") String id_habitacion,
            @ModelAttribute("id_servicio") int id_servicio, @ModelAttribute("fecha") Date fecha,
            @ModelAttribute("hora_inicio") String hora_inicio, @ModelAttribute("hora_fin") String hora_fin,
            @ModelAttribute("costo") int costo) {

        reservaServicioRepository.insertarReservaServicio(id_habitacion, id_servicio, fecha, hora_inicio, hora_fin,
                costo);

        return "redirect:/reservas_servicio/new";
    }

    @GetMapping("/reservas_servicio/{id}/edit")
    public String reservasServicioEditarForm(@ModelAttribute("id_habitacion") String id_habitacion,
            @ModelAttribute("id_servicio") int id_servicio, @ModelAttribute("fecha") Date fecha,
            @ModelAttribute("hora_inicio") String hora_inicio, @ModelAttribute("hora_fin") String hora_fin,
            @ModelAttribute("costo") int costo) {

        ReservaServicio reservaServicio = reservaServicioRepository.buscarReservaServicioPorPK(id_habitacion,
                id_servicio, fecha, hora_inicio, hora_fin, costo);

        if (reservaServicio != null) {
            reservaServicioRepository.actualizarReservaServicio(id_habitacion, id_servicio, fecha, hora_inicio,
                    hora_fin, costo);
            return "redirect:/reservas_servicio";
        } else {
            return "redirect:/reservas_servicio";
        }
    }

    @PostMapping("/reservas_servicio/{id}/edit/save")
    public String reservasServicioEditarGuardar(@ModelAttribute("id_habitacion") String id_habitacion,
            @ModelAttribute("id_servicio") int id_servicio, @ModelAttribute("fecha") Date fecha,
            @ModelAttribute("hora_inicio") String hora_inicio, @ModelAttribute("hora_fin") String hora_fin,
            @ModelAttribute("costo") int costo) {

        reservaServicioRepository.actualizarReservaServicio(id_habitacion, id_servicio, fecha, hora_inicio, hora_fin,
                costo);

        return "redirect:/reservas_servicio";
    }

    @GetMapping("/reservas_servicio/{id}/delete")
    public String reservasServicioEliminar(@ModelAttribute("id_habitacion") String id_habitacion,
            @ModelAttribute("id_servicio") int id_servicio, @ModelAttribute("fecha") Date fecha,
            @ModelAttribute("hora_inicio") String hora_inicio, @ModelAttribute("hora_fin") String hora_fin,
            @ModelAttribute("costo") int costo) {

        reservaServicioRepository.eliminarReservaServicioPorPK(id_habitacion, id_servicio, fecha, hora_inicio,
                hora_fin, costo);

        return "redirect:/reservas_servicio";
    }
}
