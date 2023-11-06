package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelesController {

    @RequestMapping("/hoteles")
    public String hoteles() {
        return "hoteles";
    }

    @RequestMapping("/estadisticas")
    public String estadisticas() {
        return "estadisticas";
    }

    @RequestMapping("/requerimiento7")
    public String requerimiento7() {
        return "requerimiento7";
    }

}
