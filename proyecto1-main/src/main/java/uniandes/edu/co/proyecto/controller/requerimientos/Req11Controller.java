package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento11Q1;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento11Q2;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento11Q3;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento11Q4;
import uniandes.edu.co.proyecto.repository.requerimientos.Req11Q1Repository;
import uniandes.edu.co.proyecto.repository.requerimientos.Req11Q2Repository;
import uniandes.edu.co.proyecto.repository.requerimientos.Req11Q3Repository;
import uniandes.edu.co.proyecto.repository.requerimientos.Req11Q4Repository;

@Controller
public class Req11Controller {

    @Autowired
    private Req11Q1Repository req11Q1Repository;

    @Autowired
    private Req11Q2Repository req11Q2Repository;

    @Autowired
    private Req11Q3Repository req11Q3Repository;

    @Autowired
    private Req11Q4Repository req11Q4Repository;

    @GetMapping("/requerimiento11")
    public String req11() {
        return "requerimiento11";
    }

    @GetMapping("/requerimiento11Q1")
    public String requerimiento11Q1(Model model) {
        Collection<Requerimiento11Q1> serviciosMasConsumidos = req11Q1Repository.serviciosMasConsumidos();
        model.addAttribute("servicios_mas_consumidos", serviciosMasConsumidos);
        return "requerimiento11Q1";
    }

    @GetMapping("/requerimiento11Q2")
    public String requerimiento11Q2(Model model) {
        Collection<Requerimiento11Q2> serviciosMenosConsumidos = req11Q2Repository.serviciosMenosConsumidos();
        model.addAttribute("servicios_menos_consumidos", serviciosMenosConsumidos);
        return "requerimiento11Q2";
    }

    @GetMapping("/requerimiento11Q3")
    public String requerimiento11Q3(Model model) {
        Collection<Requerimiento11Q3> habitacionesMasSolicitadas = req11Q3Repository.habitacionesMasSolicitadas();
        model.addAttribute("habitaciones_mas_solicitadas", habitacionesMasSolicitadas);
        return "requerimiento11Q3";
    }

    @GetMapping("/requerimiento11Q4")
    public String requerimiento11Q4(Model model) {
        Collection<Requerimiento11Q4> habitacionesMenosSolicitadas = req11Q4Repository.habitacionesMenosSolicitadas();
        model.addAttribute("habitaciones_menos_solicitadas", habitacionesMenosSolicitadas);
        return "requerimiento11Q4";
    }

}
