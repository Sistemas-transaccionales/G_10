package com.example.demo.controller;

import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.UsuarioEmbedded;
import com.example.demo.repositorio.Req4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Controller
public class Req4Controller {

    @Autowired
    private Req4Repository req4Repository;

    @GetMapping("/requerimiento4Form")
    public String req4Form() {
        return "requerimiento4Form";
    }

    @PostMapping("/requerimiento4")
    public String requerimiento4(
            @RequestParam String fecha_inicio,
            @RequestParam String fecha_fin,
            @RequestParam String servicio,
            @RequestParam String ordenarPor,
            @RequestParam String agruparPor,
            Model model) {

        // Convertir las fechas de String a Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = formatter.parse(fecha_inicio);
        Date fechaFin = formatter.parse(fecha_fin);

        // Obtener los clientes que consumieron el servicio especificado
        List<Cliente> clientes = req4Repository.findClientesByServicioAndFechaBetween(servicio, fechaInicio, fechaFin);

        // Ordenar los clientes
        if (ordenarPor.equals("nombre")) {
            clientes.sort(Comparator.comparing(Usuario::getNombre));
        } else if (ordenarPor.equals("fecha")) {
            clientes.sort(Comparator.comparing(Usuario::getFecha));
        } else if (ordenarPor.equals("numVeces")) {
            clientes.sort(Comparator.comparing(Usuario::getNumVeces));
        }

        // Agrupar los clientes
        Map<String, List<Usuario>> clientesAgrupados = new HashMap<>();
        if (agruparPor.equals("nombre")) {
            clientesAgrupados = clientes.stream().collect(Collectors.groupingBy(Usuario::getNombre));
        } else if (agruparPor.equals("fecha")) {
            clientesAgrupados = clientes.stream().collect(Collectors.groupingBy(Usuario::getFecha));
        } else if (agruparPor.equals("numVeces")) {
            clientesAgrupados = clientes.stream().collect(Collectors.groupingBy(Usuario::getNumVeces));
        }

        model.addAttribute("clientes", clientes);
        model.addAttribute("clientesAgrupados", clientesAgrupados);
        return "requerimiento4";
    }
}