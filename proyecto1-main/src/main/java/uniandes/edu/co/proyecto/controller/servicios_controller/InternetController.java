package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.Internet;
import uniandes.edu.co.proyecto.repository.servicios_repository.InternetRepository;

@Controller
public class InternetController {

    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/internet")
    public String internet(Model model) {
        model.addAttribute("internet", internetRepository.listarServiciosInternet());
        return "internet";
    }

    @GetMapping("/internet/new")
    public String internetForm(Model model) {
        model.addAttribute("internet", new Internet());
        return "internet_nuevo";
    }

    @PostMapping("/internet/new/save")
    public String internetGuardar(Internet internet) {
        internetRepository.insertarServicioInternet(internet.getId(), internet.getTipo().getId(), internet.getNombre(),
                internet.getCapacidad());
        return "redirect:/internet";
    }

    @GetMapping("/internet/{id}/edit")
    public String internetEditarForm(int id, Model model) {
        Internet internet = internetRepository.buscarServicioInternetPorId(id);
        if (internet != null) {
            model.addAttribute("internet", internet);
            return "internet_editar";
        } else {
            return "redirect:/internet";
        }
    }

    @PostMapping("/internet/{id}/edit/save")
    public String internetEditarGuardar(int id, Internet internet) {
        internetRepository.actualizarServicioInternet(id, internet.getNombre(), internet.getCapacidad());
        return "redirect:/internet";
    }

    @GetMapping("/internet/{id}/delete")
    public String internetEliminar(@PathVariable("id") int id) {
        internetRepository.eliminarServicioInternetPorId(id);
        return "redirect:/internet";
    }
}
