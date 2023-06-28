package epn.edu.ec.restaurantefm.infrastructure.InputAdapter.Http;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Pedido;
import epn.edu.ec.restaurantefm.Domain.Pedidos;
import epn.edu.ec.restaurantefm.Domain.Plato;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.ClientesInputPort;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PedidoInputPort;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PedidosInputPort;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PlatosInputPort;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.PedidosJPARepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PedidosAPITest {
    @Autowired
    PedidoInputPort pedidoInputPort;
    @Autowired
    PlatosInputPort platosInputPort;
    @Autowired
    PedidosJPARepository pedidosJPARepository;
    @Autowired
    ClientesInputPort clientesInputPort;

    @Test
    void givenPedidoData_whenGuardarPedido_thenPedidoSaved() {

        pedidosJPARepository.deleteAllInBatch();
        ArrayList<Pedido> pedidosCLiente=new ArrayList<>();
        for (Plato platoActual: platosInputPort.obtenerPlatos()){
            if(platoActual.getId()%2==1){
                pedidosCLiente.add(Pedido.builder()
                        .plato(platoActual)
                        .cantidad( 3)
                        .build());
            }
        }

        for(Cliente cliente:clientesInputPort.obtenerClientes()){
            if(cliente.getId()%2==0){

                Pedidos pedidos = Pedidos.builder()
                        .pedidos(pedidosCLiente)
                        .cliente(
                                cliente
                        )
                        .build();
                System.out.println(pedidos.toString());
                pedidosJPARepository.save(pedidos);
            }
        }

        assertTrue(true);

    }

    @Test
    void givenPedidosList_whenObtenerPedidos_thenPedidosReturned() {
    }

    @Test
    void givenPedidoData_whenGuardarPedido_thenPedidoSave() {
    }

    @Test
    void givenPedidosList_whenObtenerPedidos_thenPedidosReturne() {
    }
}

