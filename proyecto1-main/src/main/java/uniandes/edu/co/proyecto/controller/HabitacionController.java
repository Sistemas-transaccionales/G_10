package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.repository.HabitacionRepository;
import uniandes.edu.co.proyecto.repository.TipoHabitacionRepository;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.listarHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("tipos_habitacion", tipoHabitacionRepository.listarTiposHabitacion());
        return "habitacion_nuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getId(), habitacion.getTipo().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") String id, Model model) {
        Habitacion habitacion = habitacionRepository.buscarHabitacionPorId(id);

        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            model.addAttribute("tipos_habitacion", tipoHabitacionRepository.listarTiposHabitacion());
            return "habitacion_editar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("id") String id, @ModelAttribute Habitacion habitacion) {
        habitacionRepository.actualizarHabitacion(id, habitacion.getTipo().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") String id) {
        habitacionRepository.eliminarHabitacionPorId(id);
        return "redirect:/habitaciones";
    }

}
