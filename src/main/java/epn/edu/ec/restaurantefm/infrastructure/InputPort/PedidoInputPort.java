package epn.edu.ec.restaurantefm.infrastructure.InputPort;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Pedido;

import java.util.ArrayList;

public interface PedidoInputPort {
    Pedido hacerPedido(Pedido pedido);

    Pedido obtenerPedidos(Cliente cliente);
}
