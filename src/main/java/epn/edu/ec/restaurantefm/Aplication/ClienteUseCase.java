package epn.edu.ec.restaurantefm.Aplication;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.ClientesInputPort;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.ClientesJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ClienteUseCase implements ClientesInputPort {
    @Autowired
    ClientesJPARepository clientesJPARepository;

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return clientesJPARepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clientesJPARepository.getById(id);
    }

    @Override
    public ArrayList<Cliente> buscarClientesPorNombre(String nombre) {
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarClientesPorApellido(String apellido) {
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarClientesPorDireccion(String direccion) {
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarClientesPorTelefono(String telefono) {
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarClientesPorCorreo(String correo) {
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        clientesJPARepository.deleteById(id);
    }

    @Override
    public ArrayList<Cliente> obtenerClientes() {
        return (ArrayList<Cliente>) clientesJPARepository.findAll();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clientesJPARepository.save(cliente);
    }
}
