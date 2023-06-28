package epn.edu.ec.restaurantefm.infrastructure.InputPort;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Pedido;
import epn.edu.ec.restaurantefm.Domain.Pedidos;

import java.util.ArrayList;

public interface PedidosInputPort {

    Pedidos guardarPedidos(Pedidos pedidos);

    ArrayList<Pedido> obtenerPedidos(Cliente cliente);
}
