package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotocicletaTest {
    private Motocicleta motocicleta;

    @BeforeEach
    void setUp() {
        motocicleta = new Motocicleta("Ana Pérez", "123456", 2); // Espacio 2
    }

    @Test
    void testConstructor() {
        assertNotNull(motocicleta, "La motocicleta no debe ser nula después de la creación");
        assertEquals("Ana Pérez", motocicleta.getCliente().getNombre(), "El nombre del cliente no coincide");
        assertEquals(2, motocicleta.getNumeroEspacio(), "El número de espacio es incorrecto");
    }

    @Test
    void testSetTipo() {
        motocicleta.setTipo();
        assertEquals("Motocicleta", motocicleta.tipo, "El tipo de vehículo debería ser 'Motocicleta'");
    }
}
