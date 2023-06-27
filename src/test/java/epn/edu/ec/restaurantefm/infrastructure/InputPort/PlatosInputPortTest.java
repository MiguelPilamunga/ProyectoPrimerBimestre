package epn.edu.ec.restaurantefm.infrastructure.InputPort;

import epn.edu.ec.restaurantefm.Domain.Plato;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.PlatosJPARepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PlatosInputPortTest {

    @Autowired
    private PlatosJPARepository platosJPARepository;


    @Test
    void buscarTopPlatos() {
        platosJPARepository.deleteAll();
        ArrayList<Plato> platos = new ArrayList<>();
        platos.add(Plato.builder()
                .id(1L)
                .nombre("Pollo a la Parrilla")
                .descripcion("Delicioso pollo a la parrilla con especias y aderezos")
                .precio(12.5)
                .resena("¡Me encantó este plato! El pollo estaba tierno y sabroso.")
                .puntuacion(4)
                .build());
        platos.add(Plato.builder()
                .id(2L)
                .nombre("Pizza Margherita")
                .descripcion("Clásica pizza italiana con salsa de tomate, mozzarella y albahaca")
                .precio(15.0)
                .resena("Una de las mejores pizzas que he probado. ¡Muy recomendada!")
                .puntuacion(5)
                .build());
        platos.add(Plato.builder()
                .id(3L)
                .nombre("Pizza dePeperonie")
                .descripcion("Clásica pizza italiana con salsa de tomate, peperoni y piña")
                .precio(15.0)
                .resena("Una de las mejores pizzas que he probado. ¡Muy recomendada!")
                .puntuacion(3)
                .build());
        for (Plato  plato :platos){
            platosJPARepository.save(plato);
        }

        assertEquals(2, platosJPARepository.buscarPlatosTop().size());

    }

}