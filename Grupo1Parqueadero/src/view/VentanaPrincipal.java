package view;

import controller.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VentanaPrincipal extends JFrame {
    private JLabel Titulo;
    private JButton btnActualizar;
    private JButton btnAgregar;
    private JButton btnSacar;
    private JCheckBox cbBicicletas;
    private JCheckBox cbCarros;
    private JCheckBox cbMotos;
    private JCheckBox cbTodos;
    private JCheckBox cbEnParqueadero;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JLabel lbEspaciosDisponibles;
    private JLabel lbEspaciosOcupados;
    private JLabel lbEspaciosTotales;
    private JTable tblReporteVehiculos;
    private Controlador controlador;

    private CardLayout cardLayout;
    private JPanel mainPanel;


    public VentanaPrincipal() {
        initComponents();

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        jPanel1.setName("vistaPrincipal");
        AgregarVehiculo agregarVehiculo = new AgregarVehiculo();
        agregarVehiculo.setName("vistaAgregar");

        SacarVehiculo sacarVehiculo = new SacarVehiculo();
        sacarVehiculo.setName("vistaSacar");

        Factura factura = new Factura();
        factura.setName("vistaFactura");

        mainPanel.add(jPanel1, "vistaPrincipal");
        mainPanel.add(agregarVehiculo, "vistaAgregar");
        mainPanel.add(sacarVehiculo, "vistaSacar");
        mainPanel.add(factura, "vistaFactura");

        setContentPane(mainPanel);
        setLocationRelativeTo(null);

    }
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    public void setTexto(String texto) {
        lbEspaciosDisponibles.setText(texto);
    }
    public JPanel getVistaPrincipal() {
        return jPanel1;
    }
    public JButton getBtnAgregar() {
        return btnAgregar;
    }
    public JButton getBtnSacar() {
        return btnSacar;
    }
    public JTable getTabla() {
        return tblReporteVehiculos;
    }

    public void cambiarVista(JPanel vista) {
        cardLayout.show(mainPanel, vista.getName());
    }
    public void agregarVehiculoATabla(String placa, String vehiculo, String propietario, String tipo, String hora) {
        DefaultTableModel modelo = (DefaultTableModel) tblReporteVehiculos.getModel();
        modelo.addRow(new Object[]{placa, vehiculo, propietario, tipo, hora});
    }

    public int getCantidadEspaciosTotales() {
        return Integer.parseInt(lbEspaciosTotales.getText());
    }
    public void setLbEspaciosDisponibles(String texto) {
        lbEspaciosDisponibles.setText(texto);
    }
    public void setLbEspaciosOcupados(String texto) {
        lbEspaciosOcupados.setText(texto);
    }


    public JCheckBox getCbTodos() {
        return cbTodos;
    }

    public JCheckBox getCbMotos() {
        return cbMotos;
    }

    public JCheckBox getCbCarros() {
        return cbCarros;
    }

    public JCheckBox getCbBicicletas() {
        return cbBicicletas;
    }

    public JCheckBox getCbEnParqueadero() {
        return cbEnParqueadero;
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        btnAgregar = new JButton();
        btnSacar = new JButton();
        btnActualizar = new JButton();
        cbTodos = new JCheckBox();
        cbCarros = new JCheckBox();
        cbBicicletas = new JCheckBox();
        cbMotos = new JCheckBox();
        cbEnParqueadero = new JCheckBox();
        jScrollPane2 = new JScrollPane();
        tblReporteVehiculos = new JTable();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        lbEspaciosOcupados = new JLabel();
        lbEspaciosTotales = new JLabel();
        lbEspaciosDisponibles = new JLabel();
        Titulo = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setText("Agregar");


        btnSacar.setText("Sacar");


        btnActualizar.setText("Actualizar");


        cbTodos.setText("Todos");


        cbCarros.setText("Carros");


        cbBicicletas.setText("Bicicletas");


        cbMotos.setText("Motos");

        cbEnParqueadero.setText("Vehículos en el parqueadero");

        tblReporteVehiculos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Placa", "Vehiculo", "Nombre del dueño", "Tipo del vehiculo", "Hora E/S"
                }
        ));
        jScrollPane2.setViewportView(tblReporteVehiculos);

        jLabel1.setText("N° espacios totales:");

        jLabel2.setText("N° espacios disponibles:");

        jLabel3.setText("N° espacios ocupados:");

        lbEspaciosOcupados.setText("0");

        lbEspaciosTotales.setText("100");

        lbEspaciosDisponibles.setText("100");

        Titulo.setFont(new java.awt.Font("Serif", 1, 30)); // NOI18N
        Titulo.setText("PARQUEADERO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(cbTodos)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(cbCarros))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(lbEspaciosTotales)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(cbMotos)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(cbBicicletas)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(cbEnParqueadero))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(lbEspaciosDisponibles)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel3)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(lbEspaciosOcupados))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnAgregar)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnSacar)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnActualizar))
                                                        .addComponent(Titulo))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(Titulo)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnSacar)
                                                .addComponent(btnActualizar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(lbEspaciosOcupados)
                                        .addComponent(lbEspaciosTotales)
                                        .addComponent(lbEspaciosDisponibles))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbTodos)
                                        .addComponent(cbCarros)
                                        .addComponent(cbBicicletas)
                                        .addComponent(cbMotos)
                                        .addComponent(cbEnParqueadero))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        /*layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );*/
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        /*layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );*/

        pack();
    }
}
