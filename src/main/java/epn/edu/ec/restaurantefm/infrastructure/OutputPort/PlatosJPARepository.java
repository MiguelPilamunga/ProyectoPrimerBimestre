package epn.edu.ec.restaurantefm.infrastructure.OutputPort;


import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PlatosJPARepository extends JpaRepository<Plato,Long> {

    @Query(value = "SELECT * FROM plato WHERE puntuacion >= 4", nativeQuery = true)
    ArrayList<Plato> buscarPlatosTop();


}
