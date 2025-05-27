package view;

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

        setPreferredSize(new Dimension(617, 503));

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

        jLabel5.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Modelo del vehiculo");

        txtNombreCliente.setFont(new Font("Segoe UI", 0, 16)); // NOI18N


        txtDocumento.setFont(new Font("Segoe UI", 0, 16)); // NOI18N


        txtPlaca.setFont(new Font("Segoe UI", 0, 16)); // NOI18N

        txtModeloVehiculo.setFont(new Font("Segoe UI", 0, 16));

        cbTipoVehiculo.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        cbTipoVehiculo.setModel(new DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Automovil", "Motocicleta", "Bicicleta" }));


        btnGuardar.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        btnGuardar.setText("Guardar");

        btnVolver.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        btnVolver.setText("Volver");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(116, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtDocumento, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(89, 89, 89)
                                                                .addComponent(cbTipoVehiculo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(63, 63, 63)
                                                                .addComponent(btnGuardar)
                                                                .addGap(57, 57, 57)
                                                                .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel5))
                                                                .addGap(66, 66, 66)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtNombreCliente, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtModeloVehiculo, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(83, 83, 83)
                                                                .addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addComponent(lbAgregarVehiculo)))
                                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(lbAgregarVehiculo)
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombreCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtModeloVehiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(cbTipoVehiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
