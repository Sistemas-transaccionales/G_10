package uniandes.edu.co.proyecto.controller.servicios_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.servicios.RestauranteBar;
import uniandes.edu.co.proyecto.repository.servicios_repository.RestauranteBarRepository;

@Controller
public class RestauranteBarController {

    @Autowired
    private RestauranteBarRepository restauranteBarRepository;

    @GetMapping("/restaurantes_bares")
    public String restaurantesBares(Model model) {
        model.addAttribute("restaurantes_bares", restauranteBarRepository.listarRestaurantesBares());
        return "restaurantes_bares";
    }

    @GetMapping("/restaurantes_bares/new")
    public String restaurantesBaresForm(Model model) {
        model.addAttribute("restaurante_bar", new RestauranteBar());
        return "restaurante_bar_nuevo";
    }

    @PostMapping("/restaurantes_bares/new/save")
    public String restaurantesBaresGuardar(@ModelAttribute RestauranteBar restauranteBar) {
        restauranteBarRepository.insertarRestauranteBar(restauranteBar.getId(), restauranteBar.getTipo().getId(),
                restauranteBar.getNombre(), restauranteBar.getEstilo(), restauranteBar.getEs_bar(),
                restauranteBar.getHorario(), restauranteBar.getCapacidad());
        return "redirect:/restaurantes_bares";
    }

    @GetMapping("/restaurantes_bares/{id}/edit")
    public String restaurantesBaresEditarForm(@ModelAttribute RestauranteBar restauranteBar) {
        restauranteBarRepository.actualizarRestauranteBar(restauranteBar.getTipo().getId(),
                restauranteBar.getNombre(), restauranteBar.getEstilo(), restauranteBar.getEs_bar(),
                restauranteBar.getHorario(), restauranteBar.getCapacidad());
        return "redirect:/restaurantes_bares";
    }

    @PostMapping("/restaurantes_bares/{id}/edit/save")
    public String restaurantesBaresActualizar(@ModelAttribute RestauranteBar restauranteBar) {
        restauranteBarRepository.actualizarRestauranteBar(restauranteBar.getId(),
                restauranteBar.getNombre(), restauranteBar.getEstilo(), restauranteBar.getEs_bar(),
                restauranteBar.getHorario(), restauranteBar.getCapacidad());
        return "redirect:/restaurantes_bares";
    }

    @GetMapping("/restaurantes_bares/{id}/delete")
    public String restaurantesBaresEliminar(@ModelAttribute RestauranteBar restauranteBar) {
        restauranteBarRepository.eliminarRestauranteBarPorID(restauranteBar.getId());
        return "redirect:/restaurantes_bares";
    }
}
