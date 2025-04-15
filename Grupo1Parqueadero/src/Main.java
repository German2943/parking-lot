import controller.Controlador;
import model.Parqueadero;
import view.AgregarVehiculo;
import view.Factura;
import view.SacarVehiculo;
import view.VentanaPrincipal;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Crear las vistas
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            AgregarVehiculo vistaAgregar = new AgregarVehiculo();
            SacarVehiculo vistaSacar = new SacarVehiculo();
            Factura vistaFactura = new Factura();

            // Crear un mapa de tarifas
            Map<String, Double> tarifas = new HashMap<>();
            tarifas.put("Automovil", 2000.0);
            tarifas.put("Motocicleta", 1000.0);
            tarifas.put("Bicicleta", 500.0);

            // Aquí obtenemos la capacidad desde la vista
            int capacidad = ventanaPrincipal.getCantidadEspaciosTotales();

            // Crear el controlador y pasarle las vistas y el mapa de tarifas
            Controlador controlador = new Controlador(ventanaPrincipal, vistaAgregar, vistaSacar, vistaFactura, tarifas, capacidad);

            ventanaPrincipal.setControlador(controlador);
            ventanaPrincipal.setVisible(true);
        });



    }
}