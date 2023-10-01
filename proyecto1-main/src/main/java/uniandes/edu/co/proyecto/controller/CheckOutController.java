package uniandes.edu.co.proyecto.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.CheckOut;
import uniandes.edu.co.proyecto.repository.CheckOutRepository;

@Controller
public class CheckOutController {

    @Autowired
    private CheckOutRepository checkOutRepository;

    @GetMapping("/check_outs")
    public String checkOuts(Model model) {
        model.addAttribute("check_outs", checkOutRepository.listarCheckOuts());
        return "check_outs";
    }

    @GetMapping("/check_outs/new")
    public String checkOutForm(Model model) {
        model.addAttribute("check_out", new CheckOut());
        return "check_out_nuevo";
    }

    @PostMapping("/check_outs/new/save")
    public String checkOutGuardar(@ModelAttribute("id_check_in") int id_check_in, @ModelAttribute("fecha") Date fecha,
            @ModelAttribute("hora") String hora,
            @ModelAttribute("ingresos") int ingresos) {

        checkOutRepository.insertarCheckOut(id_check_in, fecha, hora, ingresos);

        return "redirect:/check_outs";
    }

    @GetMapping("/check_outs/{id}/edit")
    public String checkOutEditarForm(@ModelAttribute("id_check_in") int id_check_in, Model model) {
        CheckOut checkOut = checkOutRepository.buscarCheckOutPorId(id_check_in);
        if (checkOut != null) {
            model.addAttribute("check_out", checkOut);
            return "check_out_editar";
        } else {
            return "redirect:/check_outs";
        }
    }

    @PostMapping("/check_outs/{id}/edit/save")
    public String checkOutEditarGuardar(@PathVariable("id") int id_check_in, @ModelAttribute CheckOut checkOut) {
        checkOutRepository.actualizarCheckOut(id_check_in, checkOut.getFecha(), checkOut.getHora(),
                checkOut.getIngresos_totales());
        return "redirect:/check_outs";
    }

    @GetMapping("/check_outs/{id}/delete")
    public String checkOutEliminar(@PathVariable("id") int id_check_in) {
        checkOutRepository.eliminarCheckOutPorid(id_check_in);
        return "redirect:/check_outs";
    }
}
