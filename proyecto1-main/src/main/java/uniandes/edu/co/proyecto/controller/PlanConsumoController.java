package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.model.PlanConsumo;
import uniandes.edu.co.proyecto.repository.PlanConsumoRepository;

@Controller
public class PlanConsumoController {

    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping("/planes_consumo")
    public String planesConsumo(Model model) {
        model.addAttribute("planes_consumo", planConsumoRepository.listarPlanesConsumo());
        return "planes_consumo";
    }

    @GetMapping("/planes_consumo/new")
    public String planeConsumoForm(Model model) {
        model.addAttribute("plan_consumo", new PlanConsumo());
        return "plan_consumo_nuevo";
    }

    @PostMapping("/planes_consumo/new/save")
    public String planConsumoGuardar(@ModelAttribute PlanConsumo planConsumo) {
        planConsumoRepository.insertarPlanConsumo(planConsumo.getTipo_plan(), planConsumo.getTasa(),
                planConsumo.getMin_noches(), planConsumo.getMax_noches());

        return "redirect:/planes_consumo";
    }

    @GetMapping("/planes_consumo/{id}/edit")
    public String planConsumoEditarForm(@PathVariable("id") int id, Model model) {
        PlanConsumo planConsumo = planConsumoRepository.buscarPlanConsumoPorId(id);

        if (planConsumo != null) {
            model.addAttribute("plan_consumo", planConsumo);
            return "plan_consumo_editar";
        } else {
            return "redirect:/planes_consumo";
        }
    }

    @PostMapping("/planes_consumo/{id}/edit/save")
    public String planConsumoEditarGuardar(@PathVariable("id") int id, @ModelAttribute PlanConsumo planConsumo) {

        planConsumoRepository.actualizarPlanConsumo(id, planConsumo.getTipo_plan(), planConsumo.getTasa(),
                planConsumo.getMin_noches(), planConsumo.getMax_noches());

        return "redirect:/planes_consumo";
    }

    @GetMapping("/planes_consumo/{id}/delete")
    public String planConsumoEliminar(@PathVariable("id") int id) {
        planConsumoRepository.eliminarPlanConsumoPorId(id);
        return "redirect:/planes_consumo";
    }
}
