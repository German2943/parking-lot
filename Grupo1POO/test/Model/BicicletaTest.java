package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BicicletaTest {
    private Bicicleta bicicleta;

    @BeforeEach
    void setUp() {
        bicicleta = new Bicicleta("Luis Gómez", "987654", 3); // Espacio 3
    }

    @Test
    void testConstructor() {
        assertNotNull(bicicleta, "La bicicleta no debe ser nula después de la creación");
        assertEquals("Luis Gómez", bicicleta.getCliente().getNombre(), "El nombre del cliente no coincide");
        assertEquals(3, bicicleta.getNumeroEspacio(), "El número de espacio es incorrecto");
    }

    @Test
    void testSetTipo() {
        bicicleta.setTipo();
        assertEquals("Bicicleta", bicicleta.tipo, "El tipo de vehículo debería ser 'Bicicleta'");
    }

    @Test
    void testPlacaEsNula() {
        assertNull(bicicleta.getPlaca(), "Las bicicletas no deberían tener una placa asignada");
    }
}
