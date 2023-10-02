package uniandes.edu.co.proyecto.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.CuentaEstadia;
import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.model.ReservaHabitacion;
import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.model.primaryKeys.ReservaHabitacionPK;
import uniandes.edu.co.proyecto.model.primaryKeys.UsuarioPK;
import uniandes.edu.co.proyecto.repository.CuentaEstadiaRepository;
import uniandes.edu.co.proyecto.repository.HabitacionRepository;
import uniandes.edu.co.proyecto.repository.ReservaHabitacionRepository;
import uniandes.edu.co.proyecto.repository.UsuarioRepository;

@Controller
public class ReservaHabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @Autowired
    private CuentaEstadiaRepository cuentaEstadiaRepository;

    @GetMapping("/reservas_habitacion")
    public String reservasHabitacion(Model model) {
        model.addAttribute("reservas_habitacion", reservaHabitacionRepository.listarReservasHabitacion());
        return "reservas_habitacion";
    }

    @GetMapping("/reservas_habitacion/new")
    public String reservasHabitacionForm(Model model) {
        model.addAttribute("reserva_habitacion", new ReservaHabitacion());
        return "reserva_habitacion_nuevo";
    }

    @PostMapping("/reservas_habitacion/new/save")
    public String reservasHabitacionGuardar(@ModelAttribute("id_habitacion") String id_habitacion,
            @ModelAttribute("id_usuario") UsuarioPK usuarioPK, @ModelAttribute("fecha_entrada") Date fecha_entrada,
            @ModelAttribute("fecha_salida") Date fecha_salida, @ModelAttribute("id_plan_consumo") int id_plan_consumo,
            @ModelAttribute("num_personas") int num_personas, @ModelAttribute("costo") int costo) {

        Habitacion habitacion = habitacionRepository.buscarHabitacionPorId(id_habitacion);
        Usuario usuario = usuarioRepository.buscarUsuarioPorId(usuarioPK.getNum_doc(), usuarioPK.getTipo_doc());

        ReservaHabitacionPK pk = new ReservaHabitacionPK(habitacion, usuario, fecha_entrada, fecha_salida);
        ReservaHabitacion reservaHabitacion = new ReservaHabitacion();
        CuentaEstadia cuenta = new CuentaEstadia(habitacion, 0, 0);
        // cuentaEstadiaRepository.insertarCuentaEstadia(id_habitacion, costo, false);
        reservaHabitacion.setPk(pk);
        reservaHabitacionRepository.insertarReservaHabitacion(id_habitacion, usuarioPK.getNum_doc(),
                usuarioPK.getTipo_doc(), fecha_entrada, fecha_salida, id_plan_consumo, num_personas, costo,
                cuenta.getId());

        return "redirect:/reservas_habitacion";
    }

    @GetMapping("/reservas_habitacion/{hab}{numDoc}{tipoDoc}{fin}{fout}/edit")
    public String reservaHabitacionEditarForm(@PathVariable("hab") String hab, @PathVariable("numDoc") int num_doc,
            @PathVariable("tipoDoc") String tipo_doc,
            @PathVariable("fin") Date fin, @PathVariable("fout") Date fout, Model model) {
        ReservaHabitacion reserva = reservaHabitacionRepository.buscarReservaHabitacionPorPK(hab, num_doc, tipo_doc,
                fin, fout);
        if (reserva != null) {
            model.addAttribute("reserva_habitacion", reserva);
            return "reserva_habitacion_editar";
        } else {
            return "redirect:/reservas_habitacion";
        }
    }

    @PostMapping("/reservas_habitacion/{hab}{numDoc}{tipoDoc}{fin}{fout}/edit/save")
    public String reservaHabitacionEditarGuardar(@PathVariable("hab") String hab, @PathVariable("numDoc") int num_doc,
            @PathVariable("tipoDoc") String tipo_doc,
            @PathVariable("fin") Date fin, @PathVariable("fout") Date fout,
            @ModelAttribute ReservaHabitacion reservaHabitacion) {
        reservaHabitacionRepository.actualizarReservaHabitacion(hab, num_doc, tipo_doc, fin, fout,
                reservaHabitacion.getPlan_consumo().getId(),
                reservaHabitacion.getNum_personas(),
                reservaHabitacion.getCosto());
        return "redirect:/reservas_habitacion";
    }

    @GetMapping("/reservas_habitacion/{hab}{numDoc}{tipoDoc}{fin}{fout}/delete")
    public String reservaHabitacionEliminar(@PathVariable("hab") String hab, @PathVariable("numDoc") int num_doc,
            @PathVariable("tipoDoc") String tipo_doc,
            @PathVariable("fin") Date fin, @PathVariable("fout") Date fout) {
        reservaHabitacionRepository.eliminarReservaHabitacionPorPK(hab, num_doc,
                tipo_doc, fin,
                fout);
        return "redirect:/reservas_habitacion";
    }

}
