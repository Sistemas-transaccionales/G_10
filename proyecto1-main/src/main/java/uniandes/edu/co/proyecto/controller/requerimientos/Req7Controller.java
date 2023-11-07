package uniandes.edu.co.proyecto.controller.requerimientos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import uniandes.edu.co.proyecto.model.requerimientos.Requerimiento7;
import uniandes.edu.co.proyecto.repository.requerimientos.Req7Repository;

@Controller
public class Req7Controller {

    @Autowired
    private Req7Repository req7Repository;

    @GetMapping("/requerimiento7")
    public String requerimiento7(Model model) {
        Collection<Requerimiento7> datosClientes = req7Repository.clientesBuenos();
        model.addAttribute("datosClientes", datosClientes);
        return "requerimiento7";
    }
}
