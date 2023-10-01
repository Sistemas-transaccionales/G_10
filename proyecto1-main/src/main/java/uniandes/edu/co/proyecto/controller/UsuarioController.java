package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.Usuario;
import uniandes.edu.co.proyecto.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.listarUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario_nuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getPk().getNum_doc(), usuario.getPk().getTipo_doc(),
                usuario.getTipo().getId(), usuario.getNombre(), usuario.getEmail(), usuario.getPassword());

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{num_doc}{tipo_doc}/edit")
    public String usuarioEditarForm(@PathVariable("num_doc") int num_doc, @PathVariable("tipo_doc") String tipo_doc,
            Model model) {
        Usuario usuario = usuarioRepository.buscarUsuarioPorId(num_doc, tipo_doc);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuario_editar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{num_doc}{tipo_doc}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("num_doc") int num_doc, @PathVariable("tipo_doc") String tipo_doc,
            @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(num_doc, tipo_doc, usuario.getTipo().getId(), usuario.getNombre(),
                usuario.getEmail(), usuario.getPassword());

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{num_doc}{tipo_doc}/delete")
    public String usuarioEliminar(@PathVariable("num_doc") int num_doc, @PathVariable("tipo_doc") String tipo_doc) {
        usuarioRepository.eliminarUsuarioPorId(num_doc, tipo_doc);
        return "redirect:/usuarios";
    }
}