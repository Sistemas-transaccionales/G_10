package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.CuentaEstadia;
import uniandes.edu.co.proyecto.repository.CuentaEstadiaRepository;

@Controller
public class CuentaEstadiaController {

    @Autowired
    private CuentaEstadiaRepository cuentaEstadioRepository;

    @GetMapping("/cuentas_estadia/new")
    public String cuentaEstadiaForm(Model model) {
        model.addAttribute("cuenta_estadia", new CuentaEstadia());
        return "cuenta_estadia_nuevo";
    }

    @PostMapping("/cuentas_estadia/new/save")
    public String cuentaEstadiaGuardar(@ModelAttribute CuentaEstadia cuentaEstadia) {
        String id_hab = cuentaEstadia.getId_habitacion().getId();
        cuentaEstadioRepository.insertarCuentaEstadia(cuentaEstadia.getId(), id_hab, cuentaEstadia.getMonto(),
                cuentaEstadia.getAbierta());
        return "redirect:/cuentas_estadia";
    }

}
