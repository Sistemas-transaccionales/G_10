package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.primaryKeys.SirvenPK;
import uniandes.edu.co.proyecto.model.servicios.ProductoMenu;
import uniandes.edu.co.proyecto.model.servicios.RestauranteBar;
import uniandes.edu.co.proyecto.model.servicios.Sirven;
import uniandes.edu.co.proyecto.repository.servicios_repository.ProductoMenuRepository;
import uniandes.edu.co.proyecto.repository.servicios_repository.RestauranteBarRepository;
import uniandes.edu.co.proyecto.repository.servicios_repository.SirvenRepository;

@Controller
public class SirvenController {

    @Autowired
    private SirvenRepository sirvenRepository;

    @Autowired
    private RestauranteBarRepository restauranteBarRepository;

    @Autowired
    private ProductoMenuRepository productoMenuRepository;

    @GetMapping("/sirven")
    public String sirven(Model model) {
        model.addAttribute("sirven", sirvenRepository.listarSirven());
        return "sirven";
    }

    @GetMapping("/sirven/new")
    public String sirvenForm(Model model) {
        model.addAttribute("restaurantes", restauranteBarRepository.listarRestaurantesBares());
        model.addAttribute("productos", productoMenuRepository.listarProductosMenu());
        return "sirven_nuevo";
    }

    @PostMapping("/sirven/new/save")
    public String sirvenGuardar(@ModelAttribute("id_restaurante") int id_restaurante,
            @ModelAttribute("id_producto") int id_producto) {

        RestauranteBar restauranteBar = restauranteBarRepository.buscarRestauranteBarPorID(id_restaurante);

        ProductoMenu producto = productoMenuRepository.buscarProductoMenuPorId(id_producto);
        SirvenPK pk = new SirvenPK(restauranteBar, producto);
        Sirven sirven = new Sirven();
        sirven.setPk(pk);
        sirvenRepository.insertarSirven(id_restaurante, id_producto);

        return "redirect:/sirven";
    }

}
