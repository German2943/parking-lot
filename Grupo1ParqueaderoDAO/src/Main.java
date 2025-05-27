import controller.Controlador;
import view.AgregarVehiculo;
import view.Factura;
import view.SacarVehiculo;
import view.VentanaPrincipal;

import javax.swing.*;

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

            // Crear el controlador y pasarle las vistas y el mapa de tarifas
            Controlador controlador = new Controlador(ventanaPrincipal, vistaAgregar, vistaSacar, vistaFactura);

            ventanaPrincipal.setVisible(true);
        });

    }
}