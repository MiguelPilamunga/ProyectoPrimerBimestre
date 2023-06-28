package epn.edu.ec.restaurantefm.infrastructure.InputAdapter.Http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PedidosAPI {

    @PostMapping("/Pedido/{id}")
    public String guardarpedido(){

        return "index";
    }

    public String obtenerPedidos(){
        return " ";
    }


}
