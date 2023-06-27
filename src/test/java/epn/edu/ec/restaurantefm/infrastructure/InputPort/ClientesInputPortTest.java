package epn.edu.ec.restaurantefm.infrastructure.InputPort;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.ClientesJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientesInputPortTest {

    @Autowired
    ClientesJPARepository clientesJPARepository;
    @Test
    void agregarCliente() {
        clientesJPARepository.deleteAll();
        Cliente cliente = Cliente.builder()
                .nombre("Luis Miguel")
                .apellido("Pilamunga")
                .direccion("Santa Rosa")
                .telefono("0987654321")
                .correo_electronico("luis.pilamunga@epn.edu.ec")
                .genero("Masculino")
                .numero_identificacion("1804896841")
                .build();
        Cliente clienteEsperado=clientesJPARepository.save(cliente);
        assertEquals(cliente, clienteEsperado);
    }
}