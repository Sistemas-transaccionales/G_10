package com.example.demo.controller;

import com.example.demo.modelo.Requerimiento4;
import com.example.demo.repositorio.Req4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Req4Controller {

    @Autowired
    private Req4Repository req9Repository;

    @GetMapping("/requerimiento4Form")
    public String req9Form() {
        return "requerimiento4Form";
    }

    @PostMapping("/requerimiento4")
    public String requerimiento9(
            @RequestParam String fecha_inicio,
            @RequestParam String fecha_fin, Model model) {

        // Construir objetos y guardar en MongoDB
        // Asegúrate de convertir las fechas apropiadamente (puede necesitar
        // java.util.Date o LocalDate según tu uso)

        Requerimiento4 consumo = new Requerimiento4();
        // Configurar los campos del objeto Requerimiento9

        req9Repository.save(consumo);

        // Realizar cualquier operación adicional si es necesario

        model.addAttribute("consumo", consumo);
        return "requerimiento4";
    }
}
