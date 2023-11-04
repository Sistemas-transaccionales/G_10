package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.Salon;
import uniandes.edu.co.proyecto.repository.servicios_repository.SalonRepository;

@Controller
public class SalonController {

    @Autowired
    private SalonRepository salonRepository;

    @GetMapping("/salones")
    public String salon(Model model) {
        model.addAttribute("salones", salonRepository.listarSalones());
        return "salones";
    }

    @GetMapping("/salones/new")
    public String salonForm(Model model) {
        model.addAttribute("salon", new Salon());
        return "salon_nuevo";
    }

    @PostMapping("/salones/new/save")
    public String salonGuardar(Salon salon) {
        salonRepository.insertarSalon(salon.getTipo().getId(), salon.getNombre(), salon.getTipo_salon(),
                salon.getCapacidad(),
                salon.getCosto_por_hora(), salon.getCosto_extra());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{id}/edit")
    public String salonEditarForm(@PathVariable("id") int id, Model model) {
        Salon salon = salonRepository.buscarSalonPorID(id);
        if (salon != null) {
            model.addAttribute("salon", salon);
            return "salon_editar";
        } else {
            return "redirect:/salones";
        }
    }

    @PostMapping("/salones/{id}/edit/save")
    public String salonEditarGuardar(@PathVariable("id") int id, Salon salon) {
        salonRepository.actualizarSalon(id, salon.getNombre(), salon.getTipo_salon(),
                salon.getCapacidad(), salon.getCosto_por_hora(), salon.getCosto_extra());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{id}/delete")
    public String salonEliminar(@PathVariable("id") int id) {
        salonRepository.eliminarSalonPorID(id);
        return "redirect:/salones";
    }
}
