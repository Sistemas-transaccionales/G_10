package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.ProductoMenu;
import uniandes.edu.co.proyecto.repository.servicios_repository.ProductoMenuRepository;

@Controller
public class ProductoMenuController {

    @Autowired
    private ProductoMenuRepository productoMenuRepository;

    @GetMapping("/productos_menu")
    public String productoMenu(Model model) {
        model.addAttribute("productos_menu", productoMenuRepository.listarProductosMenu());
        return "productos_menu";
    }

    @GetMapping("/productos_menu/new")
    public String productoMenuForm(Model model) {
        model.addAttribute("producto_menu", new ProductoMenu());
        return "producto_menu_nuevo";
    }

    @PostMapping("/productos_menu/new/save")
    public String productoMenuGuardar(@ModelAttribute ProductoMenu productoMenu) {
        productoMenuRepository.insertarProductoMenu(productoMenu.getId(), productoMenu.getNombre(),
                productoMenu.getCosto());
        return "redirect:/productos_menu";
    }

    @GetMapping("productos_menu/{id}/delete")
    public String productoMenuEliminar(@PathVariable("id") int id) {
        productoMenuRepository.eliminarProductoMenuPorId(id);
        return "redirect:/productos_menu";
    }
}
