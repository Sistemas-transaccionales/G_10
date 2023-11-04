package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.PrestamoUtensilio;
import uniandes.edu.co.proyecto.repository.servicios_repository.PrestamoUtensilioRepository;

@Controller
public class PrestamoUtensilioController {

    @Autowired
    private PrestamoUtensilioRepository prestamoUtensilioRepository;

    @GetMapping("/prestamos_utensilio")
    public String prestamoUtensilio(Model model) {
        model.addAttribute("prestamos_utensilio", prestamoUtensilioRepository.listarPrestamosUtensilios());
        return "prestamos_utensilio";
    }

    @GetMapping("/prestamos_utensilio/new")
    public String prestamoUtensilioForm(Model model) {
        model.addAttribute("prestamo_utensilio", new PrestamoUtensilio());
        return "prestamo_utensilio_nuevo";
    }

    @PostMapping("/prestamos_utensilio/new/save")
    public String prestamoUtensilioGuardar(PrestamoUtensilio prestamoUtensilio) {
        prestamoUtensilioRepository.insertarPrestamoUtensilio(prestamoUtensilio.getId(),
                prestamoUtensilio.getTipo().getId(), prestamoUtensilio.getNombre(),
                prestamoUtensilio.getUtensilio(), prestamoUtensilio.getCosto_danio());
        return "redirect:/prestamos_utensilio";
    }

    @GetMapping("/prestamos_utensilio/{id}/edit")
    public String prestamoUtensilioEditarForm(int id, Model model) {
        PrestamoUtensilio prestamoUtensilio = prestamoUtensilioRepository.buscarPrestamoUtensilioPorId(id);
        if (prestamoUtensilio != null) {
            model.addAttribute("prestamo_utensilio", prestamoUtensilio);
            return "prestamo_utensilio_editar";
        } else {
            return "redirect:/prestamos_utensilio";
        }
    }

    @PostMapping("/prestamos_utensilio/{id}/edit/save")
    public String prestamoUtensilioEditarGuardar(int id, PrestamoUtensilio prestamoUtensilio) {
        prestamoUtensilioRepository.actualizarPrestamoUtensilio(id, prestamoUtensilio.getNombre(),
                prestamoUtensilio.getUtensilio(), prestamoUtensilio.getCosto_danio());
        return "redirect:/prestamos_utensilio";
    }

    @GetMapping("/prestamos_utensilio/{id}/delete")
    public String prestamoUtensilioEliminar(@PathVariable("id") int id) {
        prestamoUtensilioRepository.eliminarPrestamoUtensilioPorId(id);
        return "redirect:/prestamos_utensilio";
    }

}
