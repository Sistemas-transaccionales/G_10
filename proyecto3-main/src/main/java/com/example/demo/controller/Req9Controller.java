package com.example.demo.controller;

import com.example.demo.modelo.Requerimiento9;
import com.example.demo.repositorio.Req9Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Req9Controller {

    @Autowired
    private Req9Repository req9Repository;

    @GetMapping("/req9_form")
    public String req9Form() {
        return "req9_form";
    }

    @PostMapping("/requerimiento9")
    public String requerimiento9(@RequestParam String id_habitacion,
                                 @RequestParam String tipo_doc,
                                 @RequestParam String num_doc,
                                 @RequestParam String fecha_inicio,
                                 @RequestParam String fecha_fin,
                                 @RequestParam int num_personas,
                                 @RequestParam String nombre_plan_consumo,
                                 Model model) {

        // Construir objetos y guardar en MongoDB
        // Asegúrate de convertir las fechas apropiadamente (puede necesitar java.util.Date o LocalDate según tu uso)

        Requerimiento9 consumo = new Requerimiento9();
        // Configurar los campos del objeto Requerimiento9

        req9Repository.save(consumo);

        // Realizar cualquier operación adicional si es necesario

        model.addAttribute("consumo", consumo);
        return "requerimiento9";
    }
}
