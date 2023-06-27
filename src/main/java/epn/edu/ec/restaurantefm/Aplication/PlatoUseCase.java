package epn.edu.ec.restaurantefm.Aplication;

import epn.edu.ec.restaurantefm.Domain.Cliente;
import epn.edu.ec.restaurantefm.Domain.Plato;
import epn.edu.ec.restaurantefm.infrastructure.InputPort.PlatosInputPort;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.PlatosJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatoUseCase implements PlatosInputPort {
    @Autowired
    PlatosJPARepository platosJPARepository;

    @Override
    public ArrayList<Plato> buscarTopPlatos(){
        return platosJPARepository.buscarPlatosTop();
    }
    @Override
    public Plato agregarPlato(Plato plato) {
        return platosJPARepository.save(plato);
    }

    @Override
    public Plato buscarPlatoPorId(Long id) {
        return platosJPARepository.getById(id);
    }

    @Override
    public ArrayList<Plato> buscarPlatosPorNombre(String nombre) {
        return null;
    }

    @Override
    public ArrayList<Plato> buscarPlatosPorPrecio(double precioMin, double precioMax) {
        return null;
    }

    @Override
    public ArrayList<Plato> buscarPlatosPorDescripcion(String descripcion) {
        return null;
    }

    @Override
    public void eliminarPlato(Long id) {
        platosJPARepository.deleteById(id);
    }

    @Override
    public ArrayList<Plato> obtenerPlatos(){
        return (ArrayList<Plato>) platosJPARepository.findAll();
    }

    @Override
    public Plato actualizarPlato(Plato plato){
        return platosJPARepository.save(plato);
    }
}
