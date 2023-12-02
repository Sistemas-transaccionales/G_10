package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento8;
import uniandes.edu.co.proyecto.repository.requerimientos.Req8Repository;

@Controller
public class Req8Controller {

    @Autowired
    private Req8Repository req8Repository;

    @GetMapping("/requerimiento8")
    public String requerimiento8(Model model) {
        Collection<Requerimiento8> serviciosSinDemanda = req8Repository.servicioSinDemanda();
        model.addAttribute("servicios_sin_demanda", serviciosSinDemanda);
        return "requerimiento8";
    }
}
