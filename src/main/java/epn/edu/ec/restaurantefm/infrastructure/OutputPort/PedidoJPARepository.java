package epn.edu.ec.restaurantefm.infrastructure.OutputPort;

import epn.edu.ec.restaurantefm.Domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJPARepository extends JpaRepository<Pedido,Long> {
}
