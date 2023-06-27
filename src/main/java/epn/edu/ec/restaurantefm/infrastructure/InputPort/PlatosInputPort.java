package epn.edu.ec.restaurantefm.infrastructure.InputPort;

import epn.edu.ec.restaurantefm.Domain.Plato;

import java.util.ArrayList;

public interface PlatosInputPort {
    Plato agregarPlato(Plato plato);

    Plato buscarPlatoPorId(Long id);

    ArrayList<Plato> buscarPlatosPorNombre(String nombre);

    ArrayList<Plato> buscarPlatosPorPrecio(double precioMin, double precioMax);

    ArrayList<Plato> buscarPlatosPorDescripcion(String descripcion);

    void eliminarPlato(Long id);

    ArrayList<Plato> obtenerPlatos();
}
