package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.modelo.Req2;
import com.example.demo.repositorio.Req2Repository;

@Controller
public class Req2Controller {

    @Autowired
    private Req2Repository req2Repository;

    @GetMapping("/requerimiento2")
    public String requerimiento2(Model model) {
        Collection<Req2> habitaciones = req2Repository.habitaciones();
        model.addAttribute("habitaciones", habitaciones);
        return "requerimiento2";
    }
}