package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Dotacion;
import uniandes.edu.co.proyecto.model.Dotadas;
import uniandes.edu.co.proyecto.model.TipoHabitacion;
import uniandes.edu.co.proyecto.model.primaryKeys.DotadasPK;
import uniandes.edu.co.proyecto.repository.DotacionRepository;
import uniandes.edu.co.proyecto.repository.DotadasRepository;
import uniandes.edu.co.proyecto.repository.TipoHabitacionRepository;

@Controller
public class DotadasController {

    @Autowired
    private DotadasRepository dotadasRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    private DotacionRepository dotacionRepository;

    @GetMapping("/dotadas/new")
    public String dotadasForm(Model model) {
        model.addAttribute("dotadas", new Dotadas());
        model.addAttribute("habitaciones", tipoHabitacionRepository.listarTiposHabitacion());
        return "dotadas_nuevo";
    }

    @PostMapping("/dotadas/new/save")
    public String dotadasGuardar(@ModelAttribute("id_tipo_habitacion") int id_tipo_hab,
            @ModelAttribute("id_dotacion") int id_dot) {

        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.buscarTipoHabitacionPorId(id_tipo_hab);
        Dotacion dotacion = dotacionRepository.darDotacion(id_dot);
        DotadasPK pk = new DotadasPK(tipoHabitacion, dotacion);
        Dotadas dotadas = new Dotadas();
        dotadas.setPk(pk);
        dotadasRepository.insertarDotadas(id_tipo_hab, id_dot);

        return "redirect:/dotadas/new";
    }

}
