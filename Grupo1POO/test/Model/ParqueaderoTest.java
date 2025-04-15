package Model;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
class ParqueaderoTest {

    @Test
    void testIngresoYSalidaVehiculo() {
        // Crear un parqueadero
        Parqueadero parqueadero = new Parqueadero();

        // Verificar que el parqueadero está inicialmente vacío
        assertEquals(0, parqueadero.getContadorVehiculo());
        assertEquals(0, parqueadero.IngresosTotales());

        // Ingresar un automóvil (tipo 0)
        parqueadero.ingresarVehiculo(0, "Juan Pérez", "123456");

        // Verificar que el contador de vehículos aumentó
        assertEquals(1, parqueadero.getContadorVehiculo());

        // Verificar que el documento del vehículo está registrado
        assertTrue(parqueadero.existeDocumento(123456));



        // Registrar la salida del vehículo
        LocalTime horaSalida = parqueadero.salidaVehiculo(0, 0);
        assertNotNull(horaSalida);

        // Verificar que los ingresos han aumentado en base a la tarifa de autos
        assertEquals(0, parqueadero.IngresosTotales());

        // Verificar que el vehículo ya no está en el parqueadero
        assertNull(parqueadero.getVehiculo(0, 0));


    }
}
