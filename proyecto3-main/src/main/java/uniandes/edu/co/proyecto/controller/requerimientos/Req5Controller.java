package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento5;
import uniandes.edu.co.proyecto.repository.requerimientos.Req5Repository;

@Controller
public class Req5Controller {

    @Autowired
    private Req5Repository req5Repository;

    @GetMapping("/req5_form")
    public String req5Form() {
        return "req5_form";
    }

    @PostMapping("/requerimiento5")
    public String requerimiento5(@RequestParam("numDoc") int numDoc, @RequestParam("tipoDoc") String tipoDoc,
            @RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin, Model model) {
        System.out.println(fechaFin + " " + fechaInicio);
        Collection<Requerimiento5> consumosDeUsuario = req5Repository.consumosDeUsuario(numDoc, tipoDoc, fechaInicio,
                fechaFin);
        model.addAttribute("consumos_usuario", consumosDeUsuario);
        return "requerimiento5";
    }

}
