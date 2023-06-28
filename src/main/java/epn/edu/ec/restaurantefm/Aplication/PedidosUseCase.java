package epn.edu.ec.restaurantefm.Aplication;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Pedido;
import epn.edu.ec.restaurantefm.Domain.Pedidos;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PedidosInputPort;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.PedidosJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PedidosUseCase implements PedidosInputPort {

    @Autowired
    PedidosJPARepository pedidosJPARepository;


    @Override
    public Pedidos guardarPedidos(Cliente cliente, ArrayList<Pedido> pedidos) {
        return null;
    }

    @Override
    public Pedidos obtenerPedidosdelCliente(Long id) {
        return pedidosJPARepository.getOne(id);
    }



}
