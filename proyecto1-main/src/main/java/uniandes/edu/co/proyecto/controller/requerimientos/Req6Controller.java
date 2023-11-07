package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento6_1;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento6_2;
import uniandes.edu.co.proyecto.repository.requerimientos.Req6_1Repository;
import uniandes.edu.co.proyecto.repository.requerimientos.Req6_2Repository;

@Controller
public class Req6Controller {

    @Autowired
    private Req6_1Repository req6_1Repository;

    @Autowired
    private Req6_2Repository req6_2Repository;

    @GetMapping("/requerimiento6")
    public String requerimiento6(Model model) {
        Collection<Requerimiento6_1> altaOcupacion = req6_1Repository.altaOcupacion();
        Collection<Requerimiento6_2> demandaIngresos = req6_2Repository.demandaIngresos();
        Collection<Requerimiento6_1> bajaOcupacion = req6_1Repository.bajaOcupacion();
        model.addAttribute("altaOcupacion", altaOcupacion);
        model.addAttribute("demandaIngresos", demandaIngresos);
        model.addAttribute("bajaOcupacion", bajaOcupacion);
        return "requerimiento6";
    }

}