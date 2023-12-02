package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento3;
import uniandes.edu.co.proyecto.repository.requerimientos.Req3Repository;

@Controller
public class Req3Controller {

    @Autowired
    private Req3Repository req3Repository;

    @GetMapping("/requerimiento3")
    public String requerimiento3(Model model) {
        Collection<Requerimiento3> habitaciones = req3Repository.habitaciones();
        model.addAttribute("habitaciones", habitaciones);
        return "requerimiento3";
    }

}