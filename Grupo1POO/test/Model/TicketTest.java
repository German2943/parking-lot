package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private Ticket ticket;
    private Vehiculo vehiculo;
    private int[] tarifas = {10, 5, 2}; // Tarifas: Automóvil, Motocicleta, Bicicleta

    @BeforeEach
    void setUp() {
        vehiculo = new Automovil("Juan Pérez", "987654", 1);
        vehiculo.setHoraEntrada(); // Simula la entrada del vehículo
        vehiculo.setHoraSalida();  // Simula la salida del vehículo
        ticket = new Ticket(vehiculo, 1, 0, tarifas, 1);
    }

    @Test
    void testConstructor() {
        assertNotNull(ticket, "El ticket no debe ser nulo después de la creación");
        assertEquals("Juan Pérez", ticket.getNombreCliente(), "El nombre del cliente no coincide");
        assertEquals(1, ticket.getNumeroEspacio(), "El número de espacio es incorrecto");
    }

    @Test
    void testGetTipo() {
        assertEquals("Automovil", ticket.getTipo(), "El tipo de vehículo debería ser 'Automovil'");
    }

    @Test
    void testGetHoraEntrada() {
        assertNotNull(ticket.getHoraEntrada(), "La hora de entrada no debería ser nula");
    }

    @Test
    void testGetHoraSalida() {
        assertNotNull(ticket.getHoraSalida(), "La hora de salida no debería ser nula");
    }
}
