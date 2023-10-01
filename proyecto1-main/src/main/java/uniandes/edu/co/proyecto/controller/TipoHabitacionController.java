package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.TipoHabitacion;
import uniandes.edu.co.proyecto.repository.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tipos_habitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tipos_habitacion", tipoHabitacionRepository.listarTiposHabitacion());
        return "tipos_habitacion";
    }

    @GetMapping("/tipos_habitacion/new")
    public String tipoHabitacionForm(Model model) {
        model.addAttribute("tipo_habitacion", new TipoHabitacion());
        return "tipo_habitacion_nuevo";
    }

    @PostMapping("/tipos_habitacion/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.insertarTipoHabitacion(tipoHabitacion.getNombre(), tipoHabitacion.getCosto_por_noche(),
                tipoHabitacion.getCapacidad());
        return "redirect:/tipos_habitacion";
    }

    @GetMapping("/tipos_habitacion/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") int id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.buscarTipoHabitacionPorId(id);
        if (tipoHabitacion != null) {
            model.addAttribute(("tipo_habitacion"), tipoHabitacion);
            return "habitacion_editar";
        } else {
            return "redirect:/tipos_habitacion";
        }
    }

    @PostMapping("/tipos_habitacion/{id}/edit/save")
    public String tipoHabitacionEditarGuardar(@PathVariable("id") int id,
            @ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.actualizarTipoHabitacion(id, tipoHabitacion.getNombre(),
                tipoHabitacion.getCosto_por_noche(), tipoHabitacion.getCapacidad());
        return "redirect:/tipos_habitacion";
    }

    @GetMapping("/tipos_habitacion/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") int id) {
        tipoHabitacionRepository.eliminarTipoHabitacionPorId(id);
        return "redirect:/tipos_habitacion";
    }

}
