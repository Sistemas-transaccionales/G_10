package uniandes.edu.co.proyecto.controller.requerimientos;

import java.sql.Date;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento9;
import uniandes.edu.co.proyecto.repository.requerimientos.Req9Repository;

@Controller
public class Req9Controller {

    @Autowired
    private Req9Repository req9Repository;

    @GetMapping("/req9_form")
    public String req9Form() {
        return "req9_form";
    }

    @PostMapping("/requerimiento9")
    public String requerimiento9(@RequestParam String service_id, @RequestParam Date start_date, @RequestParam Date end_date, @RequestParam String order_by, Model model) {
    Collection<Requerimiento9> consumo = req9Repository.findConsumoByServiceAndDate(service_id, start_date, end_date, order_by);
    model.addAttribute("consumo", consumo);
    return "requerimiento9";
}
}