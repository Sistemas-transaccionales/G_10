package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.TipoServicio;
import uniandes.edu.co.proyecto.repository.servicios_repository.TipoServicioRepository;

@Controller
public class TipoServicioController {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @GetMapping("/tipos_servicio")
    public String tiposServicio(Model model) {
        model.addAttribute("tipos_servicio", tipoServicioRepository.listarTiposServicio());
        return "tipos_servicio";
    }

    @GetMapping("/tipos_servicio/new")
    public String tipoServicioForm(Model model) {
        model.addAttribute("tipo_servicio", new TipoServicio());
        return "tipo_servicio_nuevo";
    }

    @PostMapping("/tipos_servicio/new/save")
    public String tipoServicioGuardar(@ModelAttribute TipoServicio tipoServicio) {
        tipoServicioRepository.insertarTipoServicio(tipoServicio.getNombre());
        return "redirect:/tipos_servicio";
    }

    @GetMapping("/tipos_servicio/{id}/edit")
    public String tipoServicioEditarForm(@PathVariable("id") int id, Model model) {
        TipoServicio tipoServicio = tipoServicioRepository.buscarTipoServicioPorId(id);
        if (tipoServicio != null) {
            model.addAttribute(("tipo_servicio"), tipoServicio);
            return "servicio_editar";
        } else {
            return "redirect:/tipos_servicio";
        }
    }

    @PostMapping("/tipos_servicio/{id}/edit/save")
    public String tipoServicioEditarGuardar(@PathVariable("id") int id,
            @ModelAttribute TipoServicio tipoServicio) {
        tipoServicioRepository.actualizarTipoServicio(id, tipoServicio.getNombre());
        return "redirect:/tipos_servicio";
    }

    @GetMapping("/tipos_servicio/{id}/delete")
    public String tipoServicioEliminar(@PathVariable("id") int id) {
        tipoServicioRepository.eliminarTipoServicioPorId(id);
        return "redirect:/tipos_servicio";
    }

}