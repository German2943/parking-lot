package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutomovilTest {
    private Automovil automovil;

    @BeforeEach
    void setUp() {
        automovil = new Automovil("Carlos López", "987654321", 3);
    }

    @Test
    void testConstructor() {
        assertNotNull(automovil.getCliente(), "El cliente no debe ser nulo");
        assertEquals("Carlos López", automovil.getCliente().getNombre(), "El nombre del cliente es incorrecto");
        assertEquals("987654321", String.valueOf(automovil.getCliente().getDocumento()), "El documento del cliente es incorrecto");
        assertEquals(3, automovil.getNumeroEspacio(), "El número de espacio es incorrecto");
    }

    @Test
    void testSetTipo() {
        automovil.setTipo();
        assertEquals("Automovil", automovil.tipo, "El tipo del vehículo debe ser 'Automovil'");
    }
}
