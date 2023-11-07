package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repository.requerimientos.Req7Repository;

public class Req7Controller {

    @Autowired
    private Req7Repository req7Repository;

    @GetMapping("/requerimiento7")
    public String getrequerimiento7(Model model) {
        model.addAttribute("clientesBuenos", req7Repository.mostrarusuarios()); // Usar "clientesBuenos" en el modelo
        return "requerimiento7";
    }

}
