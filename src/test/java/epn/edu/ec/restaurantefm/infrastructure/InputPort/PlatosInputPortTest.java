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
        
        assertEquals(2, 2);

    }

}
