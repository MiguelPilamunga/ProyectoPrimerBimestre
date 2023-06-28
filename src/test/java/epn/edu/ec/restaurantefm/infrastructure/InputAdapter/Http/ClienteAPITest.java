package epn.edu.ec.restaurantefm.infrastructure.InputAdapter.Http;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.ClientesInputPort;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.ClientesJPARepository;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteAPITest {

    @Autowired
    ClientesInputPort clientesInputPort;
    @Autowired
    ClientesJPARepository clientesJPARepository;




    @Before
    @Test
    void givenClienteData_whenGuardarCliente_thenClienteSaved() {
        clientesJPARepository.deleteAll();
        Cliente clienteActual = Cliente.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .direccion("Av. Principal, Quito")
                .telefono("0991234567")
                .correo_electronico("juanperez@example.com")
                .genero("Masculino")
                .numero_identificacion("1712345678")
                .build();

        assertEquals(clienteActual, clientesInputPort.agregarCliente(clienteActual), "Cliente Guardado");




    }

    @Test
    void givenClientesList_whenObtenerListaClientes_thenClientesReturned() {
        clientesJPARepository.deleteAll();
        Cliente cliente = Cliente.builder()
                .nombre("John")
                .apellido("Doe")
                .direccion("123 Main St")
                .telefono("555-1234")
                .correo_electronico("john.doe@example.com")
                .genero("Masculino")
                .numero_identificacion("A12345678")
                .build();

        clientesInputPort.agregarCliente(cliente);
        assertTrue(!clientesInputPort.obtenerClientes().isEmpty());

    }
    @Test
    void givenClienteId_whenEliminarCliente_thenClienteDeleted() {
        clientesJPARepository.deleteAll();
    }

    @Test
    public void givenClienteData_whenGuardarCliente_thenClientesSaved() {


        ArrayList<Cliente> nuevosClientes = new ArrayList<>();

        Cliente cliente1 = Cliente.builder()
                .nombre("John")
                .apellido("Doe")
                .direccion("123 Main St")
                .telefono("555-1234")
                .correo_electronico("john.doe@example.com")
                .genero("Masculino")
                .numero_identificacion("A12345678")
                .build();
        nuevosClientes.add(cliente1);

        Cliente cliente2 = Cliente.builder()
                .nombre("Jane")
                .apellido("Smith")
                .direccion("456 Oak Ave")
                .telefono("555-5678")
                .correo_electronico("jane.smith@example.com")
                .genero("Femenino")
                .numero_identificacion("B87654321")
                .build();
        nuevosClientes.add(cliente2);

        Cliente cliente3 = Cliente.builder()
                .nombre("Michael")
                .apellido("Johnson")
                .direccion("789 Elm St")
                .telefono("555-9876")
                .correo_electronico("michael.johnson@example.com")
                .genero("Masculino")
                .numero_identificacion("C98765432")
                .build();
        nuevosClientes.add(cliente3);

        Cliente cliente4 = Cliente.builder()
                .nombre("Davis")
                .apellido("Oña")
                .direccion("QUITO")
                .telefono("555-4321")
                .correo_electronico("emily.davis@example.com")
                .genero("Masculino")
                .numero_identificacion("123456789")
                .build();
        nuevosClientes.add(cliente4);

        Cliente cliente5 = Cliente.builder()
                .nombre("David")
                .apellido("Wilson")
                .direccion("654 Maple Dr")
                .telefono("555-8765")
                .correo_electronico("david.wilson@example.com")
                .genero("Masculino")
                .numero_identificacion("E87654321")
                .build();
        nuevosClientes.add(cliente5);

        for (Cliente cliente : nuevosClientes) {
            clientesInputPort.agregarCliente(cliente);
        }

        ArrayList<Cliente> clientesGuardados = clientesInputPort.obtenerClientes();
        assertEquals(nuevosClientes.size(), clientesGuardados.size());

    }



}