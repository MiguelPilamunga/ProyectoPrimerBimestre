package epn.edu.ec.restaurantefm.infrastructure.InputAdapter.Http;

import epn.edu.ec.restaurantefm.infrastructure.InputPort.PlatosInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PlatoAPI {

    @Autowired
    PlatosInputPort platosInputPort;

    @GetMapping("/")
    public String getallplatos(Model model){
        String saludo = "Hola Thymeleaf";
        System.out.println("entra al metodo");
        model.addAttribute("platos",platosInputPort.obtenerPlatos());
        model.addAttribute("saludo", saludo);
        return "index";
    }
}
