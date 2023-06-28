package epn.edu.ec.restaurantefm.Aplication;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Pedido;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PedidoInputPort;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.PedidoJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PedidoUseCase implements PedidoInputPort {
    @Autowired
    PedidoJPARepository pedidoJPARepository;

    @Override
    public Pedido hacerPedido(Pedido pedido){
        return pedidoJPARepository.save(pedido);
    }

    @Override
    public Pedido obtenerPedidos(Cliente cliente){
        return null;
    }

}
