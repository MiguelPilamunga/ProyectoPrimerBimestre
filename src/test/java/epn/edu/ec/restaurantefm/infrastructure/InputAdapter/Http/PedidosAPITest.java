package epn.edu.ec.restaurantefm.infrastructure.InputAdapter.Http;

import epn.edu.ec.restaurantefm.Domain.Pedido;
import epn.edu.ec.restaurantefm.Domain.Pedidos;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PedidoInputPort;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PlatosInputPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PedidosAPITest {
    @Autowired
    PedidoInputPort pedidoInputPort;
    @Autowired
    PlatosInputPort platosInputPort;


    @Test
    void given() {

        Pedido pedidoActual=Pedido.builder().
                cantidad(3).
                plato(
                        platosInputPort.buscarPlatoPorId(3L)
                ).
                build();

        assertEquals(pedidoActual,pedidoInputPort.hacerPedido(pedidoActual));
    }

    @Test
    private void listarPedidos(){
        assertTrue(true);
    }

    @Test
    private void guardarPedidos(){


        Pedidos pedidos=Pedidos.builder().build();
    }



}

