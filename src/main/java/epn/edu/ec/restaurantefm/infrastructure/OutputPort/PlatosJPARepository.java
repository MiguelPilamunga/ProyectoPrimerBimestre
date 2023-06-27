package epn.edu.ec.restaurantefm.infrastructure.OutputPort;

import epn.edu.ec.restaurantefm.Domain.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatosJPARepository extends JpaRepository<Plato,Long> {
}
