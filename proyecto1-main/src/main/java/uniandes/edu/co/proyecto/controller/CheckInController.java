package uniandes.edu.co.proyecto.controller;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.CheckIn;
import uniandes.edu.co.proyecto.model.ReservaHabitacion;
import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repository.CheckInRepository;
import uniandes.edu.co.proyecto.repository.ReservaHabitacionRepository;

@Controller
public class CheckInController {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

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
            @ModelAttribute("id_usuario") Usuario usuario, @ModelAttribute("fecha_entrada") Date fecha_entrada,
            @ModelAttribute("fecha_salida") Date fecha_salida, @ModelAttribute("hora_salida") Time hora_salida,
            @ModelAttribute("ingresos") int ingresos) {

        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.buscarReservaHabitacionPorPK(id_habitacion,
                usuario.getPk().getNum_doc(), usuario.getPk().getTipo_doc(), fecha_entrada, fecha_salida);

        return "redirect:/check_ins";
    }

    @GetMapping("/check_ins/{hab}{numDoc}{tipoDoc}{fin}{fout}/edit")
    public String checkInEditarForm(@PathVariable("hab") int hab, @PathVariable("numDoc") int numDoc,
            @PathVariable("tipoDoc") String tipoDoc,
            @PathVariable("fin") Date fin, @PathVariable("fin") Date fout, Model model) {
        ReservaHabitacion reserva = reservaHabitacionRepository.buscarReservaHabitacionPorPK(hab, numDoc, tipoDoc, fin,
                fout);
        CheckIn checkIn = checkInRepository.buscarCheckInPorReserva(reserva);
        if (checkIn != null) {
            model.addAttribute("check_in", checkIn);
            return "check_in_editar";
        } else {
            return "redirect:/check_ins";
        }
    }

    @PostMapping("/check_ins/{hab}{numDoc}{tipoDoc}{fin}{fout}/edit/save")
    public String checkInEditarGuardar(@PathVariable("hab") int hab, @PathVariable("numDoc") int numDoc,
            @PathVariable("tipoDoc") String tipoDoc,
            @PathVariable("fin") Date fin, @PathVariable("fin") Date fout, @ModelAttribute CheckIn checkIn) {
        ReservaHabitacion reserva = reservaHabitacionRepository.buscarReservaHabitacionPorPK(hab, numDoc, tipoDoc, fin,
                fin);
        checkInRepository.actualizarCheckIn(reserva, checkIn.getHora_llegada(),
                checkIn.getId_cuenta());
        return "redirect:/check_ins";
    }

    @GetMapping("/check_ins/{hab}{numDoc}{tipoDoc}{fin}{fin}/delete")
    public String checkInEliminar(@PathVariable("hab") int hab, @PathVariable("numDoc") int numDoc,
            @PathVariable("tipoDoc") String tipoDoc,
            @PathVariable("fin") Date fin, @PathVariable("fout") Date fout) {
        ReservaHabitacion reserva = reservaHabitacionRepository.buscarReservaHabitacionPorPK(hab, numDoc, tipoDoc, fin,
                fout);
        checkInRepository.eliminarCheckInPorReserva(reserva);
        return "redirect:/check_ins";
    }
}
