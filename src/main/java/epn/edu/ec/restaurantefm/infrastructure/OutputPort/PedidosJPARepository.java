package epn.edu.ec.restaurantefm.infrastructure.OutputPort;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Pedido;
import epn.edu.ec.restaurantefm.Domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PedidosJPARepository extends JpaRepository<Pedidos,Long> {
    @Query(value = "SELECT p FROM Pedidos p WHERE p.id = :pedidoId" ,nativeQuery = true)
    Pedidos findByPedidoId(@Param("pedidoId") Long pedidoId);


}
