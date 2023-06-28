package epn.edu.ec.restaurantefm.Aplication;

import epn.edu.ec.restaurantefm.Domain.Plato;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.PlatosJPARepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlatoUseCaseTest {

    @Autowired
    PlatosJPARepository platosJPARepository;
    private PlatosJPARepository platosJPARepository1;



    @Test
    void givenPlatoData_whenAgregarPlato_thenPlatoAdded() {
        platosJPARepository.deleteAll();
        Plato platoActual = Plato.builder()
                .nombre("Spaghetti Bolognese")
                .descripcion("Deliciosos espaguetis con salsa de carne y tomate")
                .precio(12.99)
                .resena("Uno de los platos más populares de nuestra carta. ¡No te lo pierdas!")
                .puntuacion(4)
                .build();
        platosJPARepository.delete(platoActual);

        assertEquals(platoActual, platosJPARepository.save(platoActual), "Plato Guardado con exito");
    }

    @Test
    void givenPlatosList_whenGuardarPlatos_thenPlatosSaved() {
        platosJPARepository.deleteAll();
        Plato plato1 = Plato.builder()
                .nombre("Spaghetti Bolognese")
                .descripcion("Deliciosos espaguetis con salsa de carne y tomate")
                .precio(12.99)
                .resena("Uno de los platos más populares de nuestra carta. ¡No te lo pierdas!")
                .puntuacion(3)
                .build();

        Plato plato2 = Plato.builder()
                .nombre("Ceviche de camarón")
                .descripcion("Refrescante ceviche preparado con camarones frescos y jugo de limón")
                .precio(15.99)
                .resena("Un clásico de la cocina ecuatoriana. ¡Una explosión de sabores en cada bocado!")
                .puntuacion(5)
                .build();

        Plato plato3 = Plato.builder()
                .nombre("Filete de salmón a la parrilla")
                .descripcion("Filete de salmón fresco a la parrilla con salsa de mantequilla y hierbas")
                .precio(18.99)
                .resena("Una opción saludable y deliciosa. ¡Perfecto para los amantes del pescado!")
                .puntuacion(4)
                .build();

        ArrayList<Plato> listaPlatosActual = new ArrayList<>();
        listaPlatosActual.add(plato1);
        listaPlatosActual.add(plato2);
        listaPlatosActual.add(plato3);

        assertEquals(listaPlatosActual, platosJPARepository.saveAll(listaPlatosActual), "Platos Guardados");

    }
    @Test
    void givenTopPlatosList_whenBuscarTopPlatos_thenTopPlatosReturned() {
        assertTrue(!platosJPARepository.findAll().isEmpty());
    }
}