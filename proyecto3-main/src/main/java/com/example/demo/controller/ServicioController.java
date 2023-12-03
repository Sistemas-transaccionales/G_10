package com.example.demo.controller;

import com.example.demo.modelo.Servicio;
import com.example.demo.repositorio.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String getServicios(Model model) {
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicios";
    }

    @GetMapping("/servicioForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoServicio", new Servicio());
        return "servicioForm";
    }

    @PostMapping("/crearServicio")
    public String crearServicio(@ModelAttribute("nuevoServicio") Servicio nuevoServicio) {
        servicioRepository.save(nuevoServicio);
        return "redirect:/servicios";
    }

    @PostMapping("/actualizarServicio")
    public String actualizarServicio(@ModelAttribute("servicio") Servicio servicio) {
        servicioRepository.save(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/eliminarServicio/{id}")
    public String eliminarServicio(@PathVariable String id) {
        servicioRepository.deleteById(id);
        return "redirect:/servicios";
    }
}