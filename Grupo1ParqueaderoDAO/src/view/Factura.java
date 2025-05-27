package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Factura extends JPanel {
    private JButton btnPagar, btnVolver;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, lbTicket;
    private JLabel lbDocumento, lbHoraEntrada, lbHoraSalida, lbNombreCliente, lbPlaca, lbValorPagar, lbId;

    public void setTextoNombreCliente(String texto) {
        lbNombreCliente.setText(texto);
    }

    public void setTextoDocumento(String texto) {
        lbDocumento.setText(texto);
    }

    public void setTextoPlaca(String texto) {
        lbPlaca.setText(texto);
    }

    public void setTextoHoraEntrada(String texto) {
        lbHoraEntrada.setText(texto);
    }

    public void setTextoHoraSalida(String texto) {
        lbHoraSalida.setText(texto);
    }

    public void setTextoValorPagar(String texto) {
        lbValorPagar.setText(texto);
    }

    public void setTextoId(String texto) {
        lbId.setText(texto);
    }


    public Factura() {
        initComponents();
    }

    private void initComponents() {

        lbTicket = new JLabel();
        btnVolver = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        btnPagar = new JButton();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        lbHoraEntrada = new JLabel();
        lbHoraSalida = new JLabel();
        lbValorPagar = new JLabel();
        lbNombreCliente = new JLabel();
        lbDocumento = new JLabel();
        lbPlaca = new JLabel();
        lbId = new JLabel();

        lbTicket.setFont(new Font("Serif", 1, 24)); // NOI18N
        lbTicket.setText("Ticket");

        btnVolver.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        btnVolver.setText("Volver");

        jLabel7.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Id:");

        jLabel1.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Nombre del cliente:");

        jLabel2.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Documento:");

        jLabel3.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Placa del vehiculo:");

        btnPagar.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        btnPagar.setText("Pagar");


        jLabel4.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Hora de entrada:");

        jLabel5.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Hora de salida:");

        jLabel6.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Valor a pagar");

        lbId.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        lbId.setText("----------------");

        lbHoraEntrada.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        lbHoraEntrada.setText("----------------");

        lbHoraSalida.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        lbHoraSalida.setText("----------------");

        lbValorPagar.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        lbValorPagar.setText("----------------");

        lbNombreCliente.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        lbNombreCliente.setText("----------------");

        lbDocumento.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        lbDocumento.setText("----------------");

        lbPlaca.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        lbPlaca.setText("----------------");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)                                                        )
                                                .addGap(57, 57, 57)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbId)
                                                        .addComponent(lbDocumento)
                                                        .addComponent(lbPlaca)
                                                        .addComponent(lbNombreCliente)
                                                        .addComponent(lbHoraEntrada)
                                                        .addComponent(lbHoraSalida)
                                                        .addComponent(lbValorPagar)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(275, 275, 275)
                                                .addComponent(lbTicket))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(182, 182, 182)
                                                .addComponent(btnPagar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(lbTicket)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbId)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbNombreCliente)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbDocumento)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbPlaca)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbHoraEntrada)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbHoraSalida)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbValorPagar)))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnPagar)
                                        .addComponent(btnVolver))
                                .addContainerGap(80, Short.MAX_VALUE))
        );
    }

    public JLabel getLbDocumento() {
        return lbDocumento;
    }

    public JLabel getLbHoraEntrada() {
        return lbHoraEntrada;
    }

    public JLabel getLbHoraSalida() {
        return lbHoraSalida;
    }

    public JLabel getLbNombreCliente() {
        return lbNombreCliente;
    }

    public String getPlaca() {
        return lbPlaca.getText();
    }

    public String getId() {
        return lbId.getText();
    }

    public JLabel getLbValorPagar() {
        return lbValorPagar;
    }

    public JButton getBtnPagar() {
        return btnPagar;
    }

    public void addFacturaListener(ActionListener listener) {
        btnPagar.addActionListener(listener);
    }

    public void addVolverListener(ActionListener listener) {
        btnVolver.addActionListener(listener);
    }

}
