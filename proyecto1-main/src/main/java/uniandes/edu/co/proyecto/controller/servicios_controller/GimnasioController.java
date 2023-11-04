package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.Gimnasio;
import uniandes.edu.co.proyecto.repository.servicios_repository.GimnasioRepository;

@Controller
public class GimnasioController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/gimnasios")
    public String gimnasios(Model model) {
        model.addAttribute("gimnasios", gimnasioRepository.listarGimnasios());
        return "gimnasios";
    }

    @GetMapping("/gimnasios/new")
    public String gimnasioForm(Model model) {
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasio_nuevo";
    }

    @PostMapping("/gimnasios/new/save")
    public String gimnasioGuardar(@ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.insertarGimnasio(gimnasio.getId(), gimnasio.getTipo().getId(), gimnasio.getNombre(),
                gimnasio.getHora_apertura(), gimnasio.getHora_clausura(), gimnasio.getCapacidad());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id}/edit")
    public String gimnasioEditarForm(@PathVariable("id") int id, Model model) {
        Gimnasio gimnasio = gimnasioRepository.buscarGimnasioPorId(id);
        if (gimnasio != null) {
            model.addAttribute("gimnasio", gimnasio);
            return "gimnasio_editar";
        } else {
            return "redirect:/gimnasios";
        }
    }

    @PostMapping("/gimnasios/{id}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.actualizarGimnasio(id, gimnasio.getNombre(),
                gimnasio.getHora_apertura(), gimnasio.getHora_clausura(), gimnasio.getCapacidad());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id}/delete")
    public String gimnasioEliminar(@PathVariable("id") int id) {
        gimnasioRepository.eliminarGimnasioPorId(id);
        return "redirect:/gimnasios";
    }

}
