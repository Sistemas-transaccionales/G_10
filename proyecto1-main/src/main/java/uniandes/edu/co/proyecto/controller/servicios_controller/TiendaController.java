package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.Tienda;
import uniandes.edu.co.proyecto.repository.servicios_repository.TiendaRepository;

@Controller
public class TiendaController {

    @Autowired
    private TiendaRepository tiendaRepository;

    @GetMapping("/tiendas")
    public String tienda(Model model) {
        model.addAttribute("tiendas", tiendaRepository.listarTiendas());
        return "tiendas";
    }

    @GetMapping("/tiendas/new")
    public String tiendaForm(Model model) {
        model.addAttribute("tienda", new Tienda());
        return "tienda_nuevo";
    }

    @PostMapping("/tiendas/new/save")
    public String tiendaGuardar(@ModelAttribute Tienda tienda) {
        tiendaRepository.insertarTienda(tienda.getNombre(), tienda.getTipo_productos());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/edit")
    public String tiendaEditarForm(@PathVariable("id") int id, Model model) {
        Tienda tienda = tiendaRepository.buscarTiendaPorId(id);
        if (tienda != null) {
            model.addAttribute("tienda", tienda);
            return "tienda_editar";
        } else {
            return "redirect:/tiendas";
        }
    }

    @PostMapping("/tiendas/{id}/edit/save")
    public String tiendaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Tienda tienda) {
        tiendaRepository.actualizarTienda(id, tienda.getNombre(), tienda.getTipo_productos());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/delete")
    public String tiendaEliminar(@PathVariable("id") int id) {
        tiendaRepository.eliminarTiendaPorId(id);
        return "redirect:/tiendas";
    }
}
