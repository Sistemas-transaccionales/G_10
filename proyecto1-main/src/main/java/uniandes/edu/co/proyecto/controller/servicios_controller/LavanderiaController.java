package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.Lavanderia;
import uniandes.edu.co.proyecto.repository.servicios_repository.LavanderiaRepository;

@Controller
public class LavanderiaController {

    @Autowired
    private LavanderiaRepository lavanderiaRepository;

    @GetMapping("/lavanderia")
    public String lavanderia(Model model) {
        model.addAttribute("lavanderia", lavanderiaRepository.listarServiciosLavanderia());
        return "lavanderia";
    }

    @GetMapping("/lavanderia/new")
    public String lavanderiaForm(Model model) {
        model.addAttribute("lavanderia", new Lavanderia());
        return "lavanderia_nuevo";
    }

    @PostMapping("/lavanderia/new/save")
    public String lavanderiaGuardar(@ModelAttribute Lavanderia lavanderia) {
        lavanderiaRepository.insertarServicioLavanderia(lavanderia.getId(), lavanderia.getTipo().getId(),
                lavanderia.getNombre(),
                lavanderia.getTipo_prenda(), lavanderia.getNum_prendas(), lavanderia.getCosto());
        return "redirect:/lavanderia";
    }

    @GetMapping("/lavanderia/{id}/edit")
    public String lavanderiaEditarForm(@PathVariable("id") int id, Model model) {
        Lavanderia lavanderia = lavanderiaRepository.buscarServicioLavanderiaPorId(id);
        if (lavanderia != null) {
            model.addAttribute("lavanderia", lavanderia);
            return "lavanderia_editar";
        } else {
            return "redirect:/lavanderia";
        }
    }

    @PostMapping("/lavanderia/{id}/edit/save")
    public String lavanderiaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Lavanderia lavanderia) {
        lavanderiaRepository.actualizarServicioLavanderia(id, lavanderia.getNombre(), lavanderia.getTipo_prenda(),
                lavanderia.getNum_prendas(), lavanderia.getCosto());
        return "redirect:/lavanderia";
    }

    @GetMapping("/lavanderia/{id}/delete")
    public String lavanderiaEliminar(@PathVariable("id") int id) {
        lavanderiaRepository.eliminarServicioLavanderiaPorId(id);
        return "redirect:/lavanderia";
    }
}
