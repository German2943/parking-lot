package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspacioParqueoTest {
    private EspacioParqueo espacio;

    @BeforeEach
    void setUp() {
        espacio = new EspacioParqueo(5);
    }

    @Test
    void testConstructor() {
        assertEquals(5, espacio.getNumeroEspacio(), "El número de espacio debe ser 5");
        assertNull(espacio.getVehiculo(), "El espacio debe estar vacío al inicio");
    }

    @Test
    void testSetVehiculoAutomovil() {
        espacio.setVehiculo("Carlos López", "987654321", 0, 5);
        assertNotNull(espacio.getVehiculo(), "El vehículo no debe ser nulo después de asignarlo");
        assertTrue(espacio.getVehiculo() instanceof Automovil, "El vehículo debe ser un Automovil");
        assertEquals("Carlos López", espacio.getVehiculo().getCliente().getNombre(), "El nombre del cliente es incorrecto");
    }

    @Test
    void testSetVehiculoMotocicleta() {
        espacio.setVehiculo("Ana Pérez", "123456789", 1, 5);
        assertNotNull(espacio.getVehiculo(), "El vehículo no debe ser nulo después de asignarlo");
        assertTrue(espacio.getVehiculo() instanceof Motocicleta, "El vehículo debe ser una Motocicleta");
    }

    @Test
    void testSetVehiculoBicicleta() {
        espacio.setVehiculo("Luis Gómez", "555444333", 2, 5);
        assertNotNull(espacio.getVehiculo(), "El vehículo no debe ser nulo después de asignarlo");
        assertTrue(espacio.getVehiculo() instanceof Bicicleta, "El vehículo debe ser una Bicicleta");
    }

    @Test
    void testSalidaVehiculo() {
        espacio.setVehiculo("Carlos López", "987654321", 0, 5);
        assertNotNull(espacio.getVehiculo(), "El vehículo no debe ser nulo antes de la salida");
        espacio.salidaVehiculo();
        assertNull(espacio.getVehiculo(), "El espacio debe estar vacío después de la salida del vehículo");
    }
}
