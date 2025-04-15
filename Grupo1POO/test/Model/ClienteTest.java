package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testConstructor() {
        Cliente cliente = new Cliente("Juan Pérez", "123456");

        assertEquals("Juan Pérez", cliente.getNombre(), "El nombre no fue inicializado correctamente");
        assertEquals("123456", String.valueOf(cliente.getDocumento()), "El documento no fue inicializado correctamente");
    }

    @Test
    void testSetNombre() {
        Cliente cliente = new Cliente("Juan Pérez", "123456");
        cliente.setNombre("María López");

        assertEquals("María López", cliente.getNombre(), "El nombre no se estableció correctamente");
    }

    @Test
    void testSetDocumento() {
        Cliente cliente = new Cliente("Juan Pérez", "123456");
        cliente.setDocumento("789012");

        assertEquals(789012, cliente.getDocumento(), "El documento no se estableció correctamente");
    }

    @Test
    void testSetDocumentoInvalido() {
        Cliente cliente = new Cliente("Juan Pérez", "123456");

        Exception exception = assertThrows(NumberFormatException.class, () -> {
            cliente.setDocumento("ABC123");
        });

        assertTrue(exception.getMessage().contains("For input string"), "No lanzó la excepción esperada");
    }
}
