package view;

import controller.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SacarVehiculo extends JPanel {
    private JButton btnSacar, btnVolver;
    private JLabel jLabel1, jLabel2, jLabel3, lbAgregarVehiculo;
    private JTextField txtDocumento, txtNombreCliente, txtPlaca;

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SacarVehiculo() {
        initComponents();

    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        btnSacar = new JButton();
        txtNombreCliente = new JTextField();
        txtDocumento = new JTextField();
        txtPlaca = new JTextField();
        lbAgregarVehiculo = new JLabel();
        btnVolver = new JButton();

        setPreferredSize(new java.awt.Dimension(617, 503));

        lbAgregarVehiculo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        lbAgregarVehiculo.setText("Sacar Vehiculo");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Nombre del cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Documento");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Placa del vehiculo");

        btnSacar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSacar.setText("Sacar");


        txtNombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N


        txtDocumento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N


        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N


        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnVolver.setText("Volver");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1))
                                                .addGap(37, 37, 37)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtNombreCliente)
                                                        .addComponent(txtDocumento)
                                                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(218, 218, 218)
                                                .addComponent(lbAgregarVehiculo))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addComponent(btnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(lbAgregarVehiculo)
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSacar)
                                        .addComponent(btnVolver))
                                .addContainerGap(139, Short.MAX_VALUE))
        );
    }

    public void addSacarListener(ActionListener listener) {
        btnSacar.addActionListener(listener);
    }

    public void addVolverListener(ActionListener listener) {
        btnVolver.addActionListener(listener);
    }

    public String getNombreCliente() { return txtNombreCliente.getText(); }
    public String getDocumento() { return txtDocumento.getText(); }
    public String getPlaca() { return txtPlaca.getText(); }

    public JPanel getVistaSacar() {
        return new SacarVehiculo();
    }

    public JButton getBtnSacar() {
        return btnSacar;
    }
    public void cambiarVista(JPanel vista) {
        cardLayout.show(mainPanel, vista.getName());
    }
    public void limpiarCampos() {
        txtNombreCliente.setText("");
        txtDocumento.setText("");
        txtPlaca.setText("");
    }
}
