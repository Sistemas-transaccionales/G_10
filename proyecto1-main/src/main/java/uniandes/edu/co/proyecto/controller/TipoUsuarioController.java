package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.TipoUsuario;
import uniandes.edu.co.proyecto.repository.TipoUsuarioRepository;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tipos_usuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tipos_usuario", tipoUsuarioRepository.listarTiposUsuario());
        return "tipos_usuario";
    }

    @GetMapping("/tipos_usuario/new")
    public String tipoUsuarioForm(Model model) {
        model.addAttribute("tipo_usuario", new TipoUsuario());
        return "tipo_usuario_nuevo";
    }

    @PostMapping("/tipos_usuario/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getId(), tipoUsuario.getNombre());
        return "redirect:/tipos_usuario";
    }

    @GetMapping("/tipos_usuario/{id}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("id") int id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.buscarTipoUsuarioPorId(id);
        if (tipoUsuario != null) {
            model.addAttribute(("tipo_usuario"), tipoUsuario);
            return "tipos_usuario_editar"; // Cambiar aquí
        } else {
            return "redirect:/tipos_usuario";
        }
    }

    @PostMapping("/tipos_usuario/{id}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.actualizarTipoUsuario(id, tipoUsuario.getNombre());
        return "redirect:/tipos_usuario";
    }

    @GetMapping("/tipos_usuario/{id}/delete")
    public String tipoUsuarioEliminar(@PathVariable("id") int id) {
        tipoUsuarioRepository.eliminarTipoUsuarioPorId(id);
        return "redirect:/tipos_usuario";
    }

}
