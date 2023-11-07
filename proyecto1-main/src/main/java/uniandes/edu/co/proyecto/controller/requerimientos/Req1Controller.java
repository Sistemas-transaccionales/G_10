package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento1;
import uniandes.edu.co.proyecto.repository.requerimientos.Req1Repository;

@Controller
public class Req1Controller {

    @Autowired
    private Req1Repository req1Repository;

    @GetMapping("/requerimiento1")
    public String requerimiento1(Model model) {
        Collection<Requerimiento1> recoleccion = req1Repository.dinero_recolectado();
        model.addAttribute("recoleccion", recoleccion);
        return "requerimiento1";
    }

}