package com.example.demo.controller;

import com.example.demo.modelo.Habitacion;
import com.example.demo.repositorio.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String getHabitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "habitaciones";
    }

    @GetMapping("/habitacionForm")
    public String formHabitacion(Model model) {
        model.addAttribute("nuevaHabitacion", new Habitacion());
        return "habitacionForm";
    }

    @PostMapping("/crearHabitacion")
    public String crearHabitacion(@ModelAttribute("nuevaHabitacion") Habitacion nuevaHabitacion) {
        habitacionRepository.save(nuevaHabitacion);
        return "redirect:/habitaciones";
    }

    @PostMapping("/habitaciones/{id}/edit")
    public String actualizarHabitacion(@PathVariable String id, @ModelAttribute("habitacion") Habitacion habitacion) {
        if (habitacionRepository.existsById(id)) {
            habitacionRepository.save(habitacion);
        }
        return "redirect:/habitaciones";
    }

    @DeleteMapping("/habitaciones/{id}/delete")
    public String eliminarHabitacion(@PathVariable String id) {
        habitacionRepository.deleteById(id);
        return "redirect:/habitaciones";
    }
}