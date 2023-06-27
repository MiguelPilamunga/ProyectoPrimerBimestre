package epn.edu.ec.restaurantefm.infrastructure.OutputPort;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ClientesJPARepository extends JpaRepository<Cliente,Long> {
    @Query(value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:nombre% ", nativeQuery = true)
    ArrayList<Cliente> buscarClientesPorNombre(@Param("nombre") String nombre);






}
