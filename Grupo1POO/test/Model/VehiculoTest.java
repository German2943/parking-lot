package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoTest {
    private Vehiculo vehiculo;

    @BeforeEach
    void setUp() {
        // Creamos una instancia anónima de Vehiculo porque es abstracta
        vehiculo = new Vehiculo("Juan Pérez", "123456789", 5) {};
    }

    @Test
    void testHoraEntrada() {
        LocalTime horaEntrada = vehiculo.getHoraEntrada();
        assertNotNull(horaEntrada, "La hora de entrada no debe ser nula");
    }

    @Test
    void testHoraSalida() {
        vehiculo.setHoraSalida();
        LocalTime horaSalida = vehiculo.getHoraSalida();
        assertNotNull(horaSalida, "La hora de salida no debe ser nula");
    }

    @Test
    void testDuracion() {
        vehiculo.setHoraSalida();
        vehiculo.setDuracion();
        assertTrue(vehiculo.getDuracion() >= 0, "La duración no debe ser negativa");
    }

    @Test
    void testTotalPagar() {
        vehiculo.setHoraSalida();
        vehiculo.setDuracion();
        int[] tarifas = {100, 50, 30}; // Tarifas para auto, moto y bici
        int total = vehiculo.TotalPagar(0, tarifas); // Supongamos que es un auto
        assertTrue(total >= 0, "El total a pagar no debe ser negativo");
    }

    @Test
    void testCliente() {
        assertEquals("Juan Pérez", vehiculo.getCliente().getNombre());
        assertEquals("123456789", String.valueOf(vehiculo.getCliente().getDocumento()));
    }

    @Test
    void testTipoVehiculo() {
        assertEquals("Automovil", vehiculo.getTipo(0));
        assertEquals("Motocicleta", vehiculo.getTipo(1));
        assertEquals("Bicicleta", vehiculo.getTipo(2));
    }
}
