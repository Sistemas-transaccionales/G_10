package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Dotacion;
import uniandes.edu.co.proyecto.repository.DotacionRepository;

@Controller
public class DotacionController {

    @Autowired
    private DotacionRepository dotacionRepository;

    @GetMapping("/dotaciones/new")
    public String dotacionForm(Model model) {
        model.addAttribute("dotacion", new Dotacion());
        return "dotacion_nuevo";
    }

    @PostMapping("/dotaciones/new/save")
    public String dotacionGuardar(@ModelAttribute Dotacion dotacion) {
        dotacionRepository.insertarDotacion(dotacion.getId(), dotacion.getNombre());
        return "redirect:/dotaciones";
    }
}
