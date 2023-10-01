package uniandes.edu.co.proyecto.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.CheckIn;
import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repository.CheckInRepository;

@Controller
public class CheckInController {

    @Autowired
    private CheckInRepository checkInRepository;

    @GetMapping("/check_ins")
    public String checkIns(Model model) {
        model.addAttribute("check_ins", checkInRepository.listarCheckIns());
        return "check_ins";
    }

    @GetMapping("/check_ins/new")
    public String checkInForm(Model model) {
        model.addAttribute("check_in", new CheckIn());
        return "check_in_nuevo";
    }

    @PostMapping("/check_ins/new/save")
    public String checkInGuardar(@ModelAttribute("id_habitacion") int id_habitacion,
            @ModelAttribute("id_usuario") Usuario usuario, @ModelAttribute("fecha") Date fecha,
            @ModelAttribute("hora") String hora_salida) {

        checkInRepository.insertarCheckIn(id_habitacion, usuario.getPk().getNum_doc(), usuario.getPk().getTipo_doc(),
                fecha, hora_salida);

        return "redirect:/check_ins";
    }

    @GetMapping("/check_ins/{id}/edit")
    public String checkInEditarForm(@PathVariable("id") int id, Model model) {
        CheckIn checkIn = checkInRepository.buscarCheckInPorId(id);
        if (checkIn != null) {
            model.addAttribute("check_in", checkIn);
            return "check_in_editar";
        } else {
            return "redirect:/check_ins";
        }
    }

    @PostMapping("/check_ins/{id}/edit/save")
    public String checkInEditarGuardar(@PathVariable("id") int id, @ModelAttribute CheckIn checkIn) {
        checkInRepository.actualizarCheckIn(id, checkIn.getFecha(), checkIn.getHora());
        return "redirect:/check_ins";
    }

    @GetMapping("/check_ins/{id}/delete")
    public String checkInEliminar(@PathVariable("id") int id) {
        checkInRepository.eliminarCheckInPorId(id);
        return "redirect:/check_ins";
    }
}
