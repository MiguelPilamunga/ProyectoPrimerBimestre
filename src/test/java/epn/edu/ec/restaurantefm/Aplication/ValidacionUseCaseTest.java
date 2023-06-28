package epn.edu.ec.restaurantefm.Aplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidacionUseCaseTest {

    @Before
    public void setUp() {
        ValidacionUseCase validacionUseCase= new ValidacionUseCase();
    }
    @Test
    public void give_cedula_when_validate_correct_then() {

        Assert.assertFalse(ValidacionUseCase.validarCedula("0192"));
    }

    @Test
    public void give_cedula_when_validate_incorrect_then() {

        String numCedula = "1726004615";
        boolean asignado = ValidacionUseCase.validarCedula(numCedula);
        Assert.assertTrue(asignado);
    }

    @Test
    public void give_name_when_validate_correct_then() {
        String nombre = "Daniel";
        boolean asignado = ValidacionUseCase.validarNombre(nombre);
        Assert.assertTrue(asignado);
    }

    @Test
    public void give_lastname_when_validate_correct_then() {

        String apellido = "Vargas";
        boolean asignado = ValidacionUseCase.validarApellido(apellido);
        Assert.assertTrue(asignado);
    }

    @Test
    public void give_address_lenght_when_validate_incorrect_then() {

        String address = "casa";
        boolean asignado = ValidacionUseCase.validarDireccion(address);
        Assert.assertFalse(asignado);
    }

    @Test
    public void give_email_when_validate_correct_then() {

        String correo = "theadmin@gmail.com";
        boolean asignado = ValidacionUseCase.validarCorreoElectronico(correo);
        Assert.assertTrue(asignado);
    }



}