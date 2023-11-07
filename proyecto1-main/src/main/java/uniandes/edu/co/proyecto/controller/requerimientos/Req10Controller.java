package uniandes.edu.co.proyecto.controller.requerimientos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento10;
import uniandes.edu.co.proyecto.repository.requerimientos.Req10Repository;

import java.util.Collection;
import java.util.Date;

@Controller
public class Req10Controller {

    @Autowired
    private Req10Repository req10Repository;

    @GetMapping("/req10_form")
    public String req10Form() {
        return "req10_form";
    }

    @PostMapping("/requerimiento10")
    public String requerimiento10(@RequestParam String service_id, @RequestParam Date start_date, @RequestParam Date end_date, @RequestParam String order_by, Model model) {
    Collection<Requerimiento10> clientesNoConsumidores = req10Repository.findClientesNoConsumidores(service_id, start_date, end_date, order_by);
    model.addAttribute("clientes_no_consumidores", clientesNoConsumidores);
    return "requerimiento10";
    }

}
