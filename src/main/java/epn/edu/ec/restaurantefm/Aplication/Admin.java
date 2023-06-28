package epn.edu.ec.restaurantefm.Aplication;

import epn.edu.ec.restaurantefm.infrastructure.OutputPort.ClientesJPARepository;
import epn.edu.ec.restaurantefm.infrastructure.OutputPort.PlatosJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Admin {

    @Autowired
    PlatosJPARepository platosJPARepository;
    @Autowired
    ClientesJPARepository clientesJPARepository;




}
