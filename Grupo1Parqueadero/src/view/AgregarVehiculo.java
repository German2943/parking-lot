package view;

import controller.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AgregarVehiculo extends JPanel{
    private JButton btnGuardar, btnVolver;
    private JComboBox<String> cbTipoVehiculo;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, lbAgregarVehiculo;
    private JTextField txtDocumento, txtNombreCliente, txtPlaca, txtModeloVehiculo;

    public AgregarVehiculo() {
        initComponents();
    }

    private void initComponents() {


        lbAgregarVehiculo = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        txtNombreCliente = new JTextField();
        txtDocumento = new JTextField();
        txtPlaca = new JTextField();
        cbTipoVehiculo = new JComboBox<>();
        btnGuardar = new JButton();
        btnVolver = new JButton();
        jLabel5 = new JLabel();
        txtModeloVehiculo = new JTextField();

        setPreferredSize(new java.awt.Dimension(617, 503));

        lbAgregarVehiculo.setFont(new Font("Serif", 1, 24)); // NOI18N
        lbAgregarVehiculo.setText("Agregar Vehiculo");

        jLabel1.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Nombre del cliente");

        jLabel2.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Documento");

        jLabel3.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Placa o Nro  Serie");

        jLabel4.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Tipo del vehiculo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Modelo del vehiculo");

        txtNombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N


        txtDocumento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N


        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtModeloVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 16));

        cbTipoVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Automovil", "Motocicleta", "Bicicleta" }));


        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnGuardar.setText("Guardar");

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnVolver.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(116, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(89, 89, 89)
                                                                .addComponent(cbTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(63, 63, 63)
                                                                .addComponent(btnGuardar)
                                                                .addGap(57, 57, 57)
                                                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel5))
                                                                .addGap(66, 66, 66)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtModeloVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(83, 83, 83)
                                                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addComponent(lbAgregarVehiculo)))
                                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(lbAgregarVehiculo)
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtModeloVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(cbTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnGuardar)
                                        .addComponent(btnVolver))
                                .addContainerGap(83, Short.MAX_VALUE))
        );
    }

    public String getNombreCliente() { return txtNombreCliente.getText(); }
    public String getDocumento() { return txtDocumento.getText(); }
    public String getPlaca() { return txtPlaca.getText(); }
    public String getTipoVehiculo() { return cbTipoVehiculo.getSelectedItem().toString(); }
    public String getModelo() { return txtModeloVehiculo.getText(); }

    public void addGuardarListener(ActionListener listener) {
        btnGuardar.addActionListener(listener);
    }
    public void addVolverListener(ActionListener listener) {
        btnVolver.addActionListener(listener);
    }

    public void limpiarCampos() {
        txtNombreCliente.setText("");
        txtDocumento.setText("");
        txtPlaca.setText("");
        cbTipoVehiculo.setSelectedIndex(0);
        txtModeloVehiculo.setText("");
    }

}
