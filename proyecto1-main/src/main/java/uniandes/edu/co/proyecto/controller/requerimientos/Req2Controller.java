package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento2;
import uniandes.edu.co.proyecto.repository.requerimientos.Req2Repository;

@Controller
public class Req2Controller {

    @Autowired
    private Req2Repository req2Repository;

    @GetMapping("/req2_form")
    public String req2Form() {
        return "req2_form";
    }

    @PostMapping("/requerimiento2")
    public String requerimiento2(@RequestParam("fechaInicial") String fechaInicial,
            @RequestParam("fechaFinal") String fechaFinal, Model model) {
        Collection<Requerimiento2> serviciosPopulares = req2Repository.mostarServiciosPopulares(fechaInicial,
                fechaFinal);
        model.addAttribute("servicios_populares", serviciosPopulares);
        return "requerimiento2";
    }

}
