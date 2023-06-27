package epn.edu.ec.restaurantefm.infrastructure.InputAdapter.Http;

import epn.edu.ec.restaurantefm.infrastructure.InputPort.ClientesInputPort;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PlatosInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RestauranteAPI {
    @Autowired
    PlatosInputPort platosInputPort;
    @Autowired
    ClientesInputPort clientesInputPort;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        try {
            model.addAttribute("platos", platosInputPort.buscarTopPlatos());

            return "inicio";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
