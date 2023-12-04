package com.example.demo.controller;

import com.example.demo.modelo.ReservaServicio;
import com.example.demo.modelo.Usuario;
import com.example.demo.modelo.UsuarioEmbedded;
import com.example.demo.repositorio.Req4Repository;
import com.example.demo.repositorio.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/requerimiento4Form")
    public String req4Form() {
        return "requerimiento4Form";
    }

    // @PostMapping("/requerimiento4")
    // public String requerimiento4(
    // @RequestParam String fecha_inicio,
    // @RequestParam String fecha_fin,
    // @RequestParam String servicio,
    // @RequestParam String ordenarPor,
    // @RequestParam String agruparPor,
    // Model model) {

    // // Convertir las fechas de String a Date
    // LocalDate fechaInicio = LocalDate.parse(fecha_inicio);
    // LocalDate fechaFin = LocalDate.parse(fecha_fin);

    // Date fechaInicioDate = java.sql.Date.valueOf(fechaInicio);
    // Date fechaFinDate = java.sql.Date.valueOf(fechaFin);

    // // Obtener los clientes que consumieron el servicio especificado
    // List<Usuario> clientes =
    // usuarioRepository.findByServicioAndFechaBetween(servicio, fechaInicioDate,
    // fechaFinDate);

    // // // Ordenar los clientes
    // // if (ordenarPor.equals("nombre")) {
    // // clientes.sort(Comparator.comparing(Usuario::getNombre));
    // // } else if (ordenarPor.equals("fecha")) {
    // // clientes.sort(Comparator.comparing(Usuario::getFecha));
    // // } else if (ordenarPor.equals("numVeces")) {
    // // clientes.sort(Comparator.comparing(Usuario::getNumVeces));
    // // }

    // // // Agrupar los clientes
    // // Map<String, List<Usuario>> clientesAgrupados = new HashMap<>();
    // // if (agruparPor.equals("nombre")) {
    // // clientesAgrupados =
    // // clientes.stream().collect(Collectors.groupingBy(Usuario::getNombre));
    // // } else if (agruparPor.equals("fecha")) {
    // // clientesAgrupados =
    // // clientes.stream().collect(Collectors.groupingBy(Usuario::getFecha));
    // // } else if (agruparPor.equals("numVeces")) {
    // // clientesAgrupados =
    // // clientes.stream().collect(Collectors.groupingBy(Usuario::getNumVeces));
    // // }

    // model.addAttribute("clientes", clientes);
    // // model.addAttribute("clientesAgrupados", clientesAgrupados);
    // return "requerimiento4";
    // }
}