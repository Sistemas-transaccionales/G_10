package com.example.demo.controller;

import com.example.demo.modelo.ReservaServicio;
import com.example.demo.repositorio.ReservaServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservaServicioController {

    @Autowired
    private ReservaServicioRepository reservaServicioRepository;

    @GetMapping("/reservasServicios")
    public String getReservasServicios(Model model) {
        model.addAttribute("reservasServicios", reservaServicioRepository.findAll());
        return "reservasServicios";
    }

    @GetMapping("/reservaServicioForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevaReservaServicio", new ReservaServicio());
        return "reservaServicioForm";
    }

    @PostMapping("/crearReservaServicio")
    public String crearReservaServicio(@ModelAttribute("nuevaReservaServicio") ReservaServicio nuevaReservaServicio) {
        reservaServicioRepository.save(nuevaReservaServicio);
        return "redirect:/reservasServicios";
    }

    @PostMapping("/actualizarReservaServicio")
    public String actualizarReservaServicio(@ModelAttribute("reservaServicio") ReservaServicio reservaServicio) {
        reservaServicioRepository.save(reservaServicio);
        return "redirect:/reservasServicios";
    }

    @GetMapping("/eliminarReservaServicio/{id}")
    public String eliminarReservaServicio(@PathVariable String id) {
        reservaServicioRepository.deleteById(id);
        return "redirect:/reservasServicios";
    }
}