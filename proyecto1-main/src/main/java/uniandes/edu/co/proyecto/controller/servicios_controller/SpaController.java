package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.Spa;
import uniandes.edu.co.proyecto.repository.servicios_repository.SpaRepository;

@Controller
public class SpaController {

    @Autowired
    private SpaRepository spaRepository;

    @GetMapping("/spas")
    public String spa(Model model) {
        model.addAttribute("spas", spaRepository.listarSpas());
        return "spas";
    }

    @GetMapping("/spas/new")
    public String spaForm(Model model) {
        model.addAttribute("spa", new Spa());
        return "spa_nuevo";
    }

    @PostMapping("/spas/new/save")
    public String spaGuardar(@ModelAttribute Spa spa) {
        spaRepository.insertarSpa(spa.getNombre(), spa.getCosto(), spa.getDuracion());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/edit")
    public String spaEditarForm(@PathVariable("id") int id, Model model) {
        Spa spa = spaRepository.buscarSpaPorId(id);
        if (spa != null) {
            model.addAttribute("spa", spa);
            return "spa_editar";
        } else {
            return "redirect:/spas";
        }
    }

    @PostMapping("/spas/{id}/edit/save")
    public String spaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Spa spa) {
        spaRepository.actualizarSpa(id, spa.getNombre(), spa.getCosto(), spa.getDuracion());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/delete")
    public String spaEliminar(@PathVariable("id") int id) {
        spaRepository.eliminarSpaPorId(id);
        return "redirect:/spas";
    }
}
