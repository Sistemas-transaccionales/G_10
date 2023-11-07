package uniandes.edu.co.proyecto.controller.requerimientos;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento4;
import uniandes.edu.co.proyecto.repository.requerimientos.Req4Repository;

@Controller
public class Req4Controller {

    @Autowired
    private Req4Repository req4Repository;

    @GetMapping("/req4_form")
    public String req4Form() {
        return "req4_form";
    }

    @PostMapping("/requerimiento4")
    public String requerimiento4(@RequestParam BigDecimal costoMinimo,
            @RequestParam BigDecimal costoMaximo, @RequestParam int capacidadMinima, @RequestParam int capacidadMaxima, Model model) {
        Collection<Requerimiento4> resultados = req4Repository.serviciosFiltrados(costoMinimo, costoMaximo, capacidadMinima, capacidadMaxima);
        model.addAttribute("resultados", resultados);
        return "requerimiento4";
    }
    
}