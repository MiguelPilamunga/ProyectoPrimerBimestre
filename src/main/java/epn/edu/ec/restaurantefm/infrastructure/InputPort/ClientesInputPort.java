package epn.edu.ec.restaurantefm.infrastructure.InputPort;

import epn.edu.ec.restaurantefm.Domain.Cliente;

import java.util.ArrayList;

public interface ClientesInputPort {
    Cliente agregarCliente(Cliente cliente);

    Cliente buscarClientePorId(Long id);

    ArrayList<Cliente> buscarClientesPorNombre(String nombre);

    ArrayList<Cliente> buscarClientesPorApellido(String apellido);

    ArrayList<Cliente> buscarClientesPorDireccion(String direccion);

    ArrayList<Cliente> buscarClientesPorTelefono(String telefono);

    ArrayList<Cliente> buscarClientesPorCorreo(String correo);

    void eliminarCliente(Long id);

    ArrayList<Cliente> obtenerClientes();

    Cliente actualizarCliente(Cliente cliente);
}
