package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SacarVehiculo extends JPanel {
    private JButton btnSacar, btnVolver;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, lbAgregarVehiculo;
    private JTextField txtId, txtDocumento, txtNombreCliente, txtPlaca;

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SacarVehiculo() {
        initComponents();

    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        btnSacar = new JButton();
        txtId = new JTextField();
        txtNombreCliente = new JTextField();
        txtDocumento = new JTextField();
        txtPlaca = new JTextField();
        lbAgregarVehiculo = new JLabel();
        btnVolver = new JButton();

        setPreferredSize(new Dimension(617, 503));

        lbAgregarVehiculo.setFont(new Font("Serif", 1, 24)); // NOI18N
        lbAgregarVehiculo.setText("Sacar Vehiculo");

        jLabel4.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Id");

        jLabel1.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Nombre del cliente");

        jLabel2.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Documento");

        jLabel3.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Placa del vehiculo");

        btnSacar.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        btnSacar.setText("Sacar");

        txtId.setFont(new Font("Segoe UI", 0, 16)); // NOI18N

        txtNombreCliente.setFont(new Font("Segoe UI", 0, 16)); // NOI18N


        txtDocumento.setFont(new Font("Segoe UI", 0, 16)); // NOI18N


        txtPlaca.setFont(new Font("Segoe UI", 0, 16)); // NOI18N


        btnVolver.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        btnVolver.setText("Volver");


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1))
                                                .addGap(37, 37, 37)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtId)
                                                        .addComponent(txtNombreCliente)
                                                        .addComponent(txtDocumento)
                                                        .addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(218, 218, 218)
                                                .addComponent(lbAgregarVehiculo))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addComponent(btnSacar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(lbAgregarVehiculo)
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombreCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
    public String getId() { return txtId.getText(); }

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
        txtId.setText("");
        txtNombreCliente.setText("");
        txtDocumento.setText("");
        txtPlaca.setText("");
    }
}
