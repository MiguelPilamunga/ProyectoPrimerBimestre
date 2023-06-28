package epn.edu.ec.restaurantefm.infrastructure.OutputPort;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Pedido;
import epn.edu.ec.restaurantefm.Domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PedidosJPARepository extends JpaRepository<Pedidos,Long> {

}
