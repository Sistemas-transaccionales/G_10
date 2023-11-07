package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento12;
import uniandes.edu.co.proyecto.repository.requerimientos.Req12Repository;

@Controller
public class Req12Controller {

    @Autowired
    private Req12Repository req12Repository;

    @GetMapping("/requerimiento12")
    public String requerimiento12(Model model) {
        Collection<Requerimiento12> clientesExcelentes = req12Repository.getClientesExcelentes();
        model.addAttribute("clientesExcelentes", clientesExcelentes);
        return "requerimiento12";
    }

}