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

import uniandes.edu.co.proyecto.model.CheckOut;
import uniandes.edu.co.proyecto.model.ReservaHabitacion;
import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repository.CheckOutRepository;
import uniandes.edu.co.proyecto.repository.ReservaHabitacionRepository;
import uniandes.edu.co.proyecto.repository.UsuarioRepository;

@Controller
public class CheckOutController {

    @Autowired
    private CheckOutRepository checkOutRepository;

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

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
    public String checkOutGuardar(@ModelAttribute("id_habitacion") int id_habitacion,
            @ModelAttribute("id_usuario") Usuario usuario, @ModelAttribute("fecha_entrada") Date fecha_entrada,
            @ModelAttribute("fecha_salida") Date fecha_salida, @ModelAttribute("hora_salida") Time hora_salida,
            @ModelAttribute("ingresos") int ingresos) {

        ReservaHabitacion reservaHabitacion = reservaHabitacionRepository.buscarReservaHabitacionPorPK(id_habitacion,
                usuario.getPk().getNum_doc(), usuario.getPk().getTipo_doc(), fecha_entrada, fecha_salida);

        return "redirect:/check_outs";
    }

    @GetMapping("/check_outs/{hab}{numDoc}{tipoDoc}{fin}{fout}/edit")
    public String checkOutEditarForm(@PathVariable("hab") int hab, @PathVariable("numDoc") int numDoc,
            @PathVariable("tipoDoc") String tipoDoc,
            @PathVariable("fin") Date fin, @PathVariable("fout") Date fout, Model model) {
        ReservaHabitacion reserva = reservaHabitacionRepository.buscarReservaHabitacionPorPK(hab, numDoc, tipoDoc, fin,
                fout);
        CheckOut checkOut = checkOutRepository.buscarCheckOutPorReserva(reserva);
        if (checkOut != null) {
            model.addAttribute("check_out", checkOut);
            return "check_out_editar";
        } else {
            return "redirect:/check_outs";
        }
    }

    @PostMapping("/check_outs/{hab}{numDoc}{tipoDoc}{fin}{fout}/edit/save")
    public String checkOutEditarGuardar(@PathVariable("hab") int hab, @PathVariable("numDoc") int numDoc,
            @PathVariable("tipoDoc") String tipoDoc,
            @PathVariable("fin") Date fin, @PathVariable("fout") Date fout, @ModelAttribute CheckOut checkOut) {
        ReservaHabitacion reserva = reservaHabitacionRepository.buscarReservaHabitacionPorPK(hab, numDoc, tipoDoc, fin,
                fout);
        checkOutRepository.actualizarCheckOut(reserva, checkOut.getHora_salida(),
                checkOut.getIngresos_totales());
        return "redirect:/check_outs";
    }

    @GetMapping("/check_outs/{hab}{numDoc}{tipoDoc}{fin}{fout}/delete")
    public String checkOutEliminar(@PathVariable("hab") int hab, @PathVariable("numDoc") int numDoc,
            @PathVariable("tipoDoc") String tipoDoc,
            @PathVariable("fin") Date fin, @PathVariable("fout") Date fout) {
        ReservaHabitacion reserva = reservaHabitacionRepository.buscarReservaHabitacionPorPK(hab, numDoc, tipoDoc, fin,
                fout);
        checkOutRepository.eliminarCheckOutPorReserva(reserva);
        return "redirect:/check_outs";
    }
}
