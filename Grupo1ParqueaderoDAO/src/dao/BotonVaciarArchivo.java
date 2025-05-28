package dao;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class BotonVaciarArchivo extends JButton {

    public BotonVaciarArchivo() {


        // Acción personalizada
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarArchivo("recursos/historial_parqueadero.csv");
                vaciarArchivo("recursos/automoviles.csv");
                vaciarArchivo("recursos/clientes.csv");
                vaciarArchivo("recursos/espacios_parqueo.csv");
                vaciarArchivo("recursos/motocicletas.csv");
                vaciarArchivo("recursos/tickets.csv");
            }
        });
    }

    private void vaciarArchivo(String ruta) {
        try (FileWriter fw = new FileWriter(ruta)) {
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al vaciar el archivo.");
        }
    }
}
