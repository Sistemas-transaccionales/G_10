package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.Piscina;
import uniandes.edu.co.proyecto.repository.servicios_repository.PiscinaRepository;

@Controller
public class PiscinaController {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/piscinas")
    public String piscina(Model model) {
        model.addAttribute("piscinas", piscinaRepository.listarPiscinas());
        return "piscinas";
    }

    @GetMapping("/piscinas/new")
    public String piscinaForm(Model model) {
        model.addAttribute("piscina", new Piscina());
        return "piscina_nuevo";
    }

    @PostMapping("/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina) {
        piscinaRepository.insertarPiscina(piscina.getId(), piscina.getTipo().getId(), piscina.getNombre(),
                piscina.getCapacidad(), piscina.getArea(), piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/edit")
    public String piscinaEditarForm(int id, Model model) {
        Piscina piscina = piscinaRepository.buscarPiscinaPorId(id);
        if (piscina != null) {
            model.addAttribute("piscina", piscina);
            return "piscina_editar";
        } else {
            return "redirect:/piscinas";
        }
    }

    @PostMapping("/piscinas/{id}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Piscina piscina) {
        piscinaRepository.actualizarPiscina(id, piscina.getNombre(), piscina.getCapacidad(), piscina.getArea(),
                piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/delete")
    public String piscinaEliminar(@PathVariable("id") int id) {
        piscinaRepository.eliminarPiscinaPorId(id);
        return "redirect:/piscinas";
    }

}
