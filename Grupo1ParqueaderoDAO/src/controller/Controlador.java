package controller;

import dao.*;
import model.*;
import view.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controlador {
    VentanaPrincipal vistaPrincipal;
    AgregarVehiculo vistaAgregar;
    SacarVehiculo vistaSacar;
    Factura vistaFactura;
    private Parqueadero parqueadero;
    private final Map<String, Double> tarifas;
    private final int capacidad;
    private TicketDao ticketDao;
    private AutomovilDao autoDao;
    private MotocicletaDao motoDao;
    private BicicletaDao biciDao;
    private ClienteDao clienteDao;
    private EspacioParqueoDao espacioParqueoDao;


    public Controlador(VentanaPrincipal vistaPrincipal, AgregarVehiculo vistaAgregar, SacarVehiculo vistaSacar, Factura vistaFactura){
        this.vistaPrincipal = vistaPrincipal;
        this.vistaAgregar = vistaAgregar;
        this.vistaSacar = vistaSacar;
        this.vistaFactura = vistaFactura;
        this.ticketDao = new TicketDaoImpl();
        this.biciDao = new BicicletaDaoImpl();
        this.motoDao = new MotocicletaDaoImpl();
        this.autoDao = new AutomovilDaoImpl();
        this.clienteDao = new ClienteDaoImpl();
        this.espacioParqueoDao = new EspacioParqueoDaoImpl();

        this.capacidad = 100;

        this.tarifas = new HashMap<>();
        tarifas.put("Automovil", 2000.0);
        tarifas.put("Motocicleta", 1000.0);
        tarifas.put("Bicicleta", 500.0);
        this.parqueadero = new Parqueadero(capacidad, tarifas);
        vistaPrincipal.setEspaciosTotales(String.valueOf(capacidad));
        vistaPrincipal.setLbEspaciosDisponibles(String.valueOf(capacidad));
        vistaPrincipal.setLbEspaciosOcupados("0");

        this.vistaPrincipal.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarAVistaAgregar();
            }
        });

        this.vistaPrincipal.getBtnSacar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarAVistaSacar();
            }
        });

        this.vistaSacar.getBtnSacar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            }
        });

        this.vistaFactura.getBtnPagar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = vistaFactura.getId().trim();

                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay vehículo seleccionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Ticket ticket = parqueadero.getTicketPorId(Integer.valueOf(id));
                if (ticket == null) {
                    // No existe ticket con ese ID
                    return;
                }

                if (ticket.getHoraSalida() != null) {
                    JOptionPane.showMessageDialog(null, "Este vehículo ya salió del parqueadero.");
                    return;
                }

                //dar salida
                LocalDateTime horaSalida = LocalDateTime.now();
                ticket = parqueadero.darSalidaVehiculoPorIdTicket(Integer.valueOf(id), horaSalida);
                ticketDao.actualizar(ticket);

                if (ticket != null) {

                    DefaultTableModel modeloTabla = (DefaultTableModel) vistaPrincipal.getTabla().getModel();
                    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                        String idTabla = (String) modeloTabla.getValueAt(i, 0);
                        if (idTabla.equals(id)) {  // buscamos con la placa o documento
                            String horaEntradalb = vistaFactura.getLbHoraEntrada().getText();
                            String horaSalidalb = vistaFactura.getLbHoraSalida().getText();
                            modeloTabla.setValueAt(horaEntradalb + " / " + horaSalidalb, i, 5);
                            break;
                        }
                    }

                    vistaPrincipal.setLbEspaciosDisponibles(String.valueOf(parqueadero.getEspaciosDisponibles()));
                    vistaPrincipal.setLbEspaciosOcupados(String.valueOf(parqueadero.getEspaciosOcupados()));

                    JOptionPane.showMessageDialog(null, "Pago exitoso. Vehículo retirado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El vehículo ya ha salido o no se encuentra.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Volver a la vista principal
                vistaPrincipal.cambiarVista(vistaPrincipal.getVistaPrincipal());
                vistaSacar.limpiarCampos();

                actualizarTablaSegunFiltros();
            }

        });


        vistaAgregar.addGuardarListener(new GuardarVehiculoListener());
        vistaAgregar.addVolverListener(new VolverListener());

        vistaSacar.addSacarListener(new SacarVehiculoListener());
        vistaSacar.addVolverListener(new VolverListener2());

        vistaFactura.addVolverListener(new VolverListener3());

        vistaPrincipal.getCbTodos().addActionListener(e -> actualizarTablaSegunFiltros());
        vistaPrincipal.getCbCarros().addActionListener(e -> actualizarTablaSegunFiltros());
        vistaPrincipal.getCbMotos().addActionListener(e -> actualizarTablaSegunFiltros());
        vistaPrincipal.getCbBicicletas().addActionListener(e -> actualizarTablaSegunFiltros());
        vistaPrincipal.getCbEnParqueadero().addActionListener(e -> actualizarTablaSegunFiltros());


        List<Ticket> ticketsActivos = ticketDao.leerTodos();

        for (Ticket t : ticketsActivos) {
            parqueadero.agregarVehiculoConTicket(t);  // agrega vehículos cargados desde BD al parqueadero en memoria
            if (t.getIdTicket() > Ticket.getContador()) {
                Ticket.setContador(t.getIdTicket() + 1);
            }
        }
        // Actualiza la vista con los datos
        actualizarTablaSegunFiltros();
    }


    private void ventanaModificación(){

    }


    private void actualizarTablaSegunFiltros() {
        DefaultTableModel modelo = (DefaultTableModel) vistaPrincipal.getTabla().getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        boolean mostrarCarros = vistaPrincipal.getCbCarros().isSelected();
        boolean mostrarMotos = vistaPrincipal.getCbMotos().isSelected();
        boolean mostrarBicicletas = vistaPrincipal.getCbBicicletas().isSelected();
        boolean mostrarTodos = vistaPrincipal.getCbTodos().isSelected();
        boolean soloEnParqueadero = vistaPrincipal.getCbEnParqueadero().isSelected();

        if (mostrarTodos || (!mostrarCarros && !mostrarMotos && !mostrarBicicletas)) {
            List<Ticket> todos = parqueadero.getTicketsFiltrados(null, soloEnParqueadero);
            agregarTicketsATabla(todos);
        } else {
            if (mostrarCarros) {
                List<Ticket> carros = parqueadero.getTicketsFiltrados("Automovil", soloEnParqueadero);
                agregarTicketsATabla(carros);
            }
            if (mostrarMotos) {
                List<Ticket> motos = parqueadero.getTicketsFiltrados("Motocicleta", soloEnParqueadero);
                agregarTicketsATabla(motos);
            }
            if (mostrarBicicletas) {
                List<Ticket> bicis = parqueadero.getTicketsFiltrados("Bicicleta", soloEnParqueadero);
                agregarTicketsATabla(bicis);
            }

        }
    }

    private void agregarTicketsATabla(List<Ticket> tickets) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (Ticket t : tickets) {
            String id = String.valueOf(t.getIdTicket());
            Vehiculo v = t.getVehiculo();
            String placa = (v instanceof Bicicleta) ?  ((Bicicleta) v).getNumeroSerie():
                    (v instanceof Automovil) ? ((Automovil) v).getPlaca() :
                            ((Motocicleta) v).getPlaca();

            String nombre = v.getCliente().getNombre();
            String tipo = v.getTipo();
            String horaEntrada = t.getHoraEntrada().format(formatter);
            String horaSalida = (t.getHoraSalida() != null) ? t.getHoraSalida().format(formatter) : "";

            vistaPrincipal.agregarVehiculoATabla(id, placa, v.getModelo(), nombre, tipo, horaEntrada + " / " + horaSalida);
        }
    }

    private void prepararFactura(String ticket) {
        // Busca por ticket
        Ticket t = parqueadero.buscarTicketPorId(Integer.valueOf(ticket));

        if (ticket != null) {
            Cliente cliente = t.getCliente();
            Vehiculo vehiculo = t.getVehiculo();

            String placaMostrar = "";
            if (vehiculo instanceof Automovil) {
                placaMostrar = ((Automovil) vehiculo).getPlaca();
            } else if (vehiculo instanceof Motocicleta) {
                placaMostrar = ((Motocicleta) vehiculo).getPlaca();
            } else if (vehiculo instanceof Bicicleta) {
                placaMostrar = ((Bicicleta) vehiculo).getNumeroSerie();
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            String horaEntradaFormateada = t.getHoraEntrada().format(formatter);
            String horaSalidaFormateada = LocalDateTime.now().format(formatter); // temporal para mostrar

            vistaFactura.setTextoId(String.valueOf(t.getIdTicket()));
            vistaFactura.setTextoNombreCliente(cliente.getNombre());
            vistaFactura.setTextoDocumento(cliente.getDocumento());
            vistaFactura.setTextoPlaca(placaMostrar);
            vistaFactura.setTextoHoraEntrada(horaEntradaFormateada);
            vistaFactura.setTextoHoraSalida(horaSalidaFormateada);
            vistaFactura.setTextoValorPagar(String.format("%.2f", parqueadero.calcularValorPorTicket(t, LocalDateTime.now())));

            cambiarAVistaFactura();
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void cambiarAVistaAgregar() {
        vistaPrincipal.cambiarVista(vistaAgregar);
    }
    private void cambiarAVistaSacar() {
        vistaPrincipal.cambiarVista(vistaSacar);
    }
    private void cambiarAVistaFactura() {
        vistaPrincipal.cambiarVista(vistaFactura);
    }

    class GuardarVehiculoListener implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = vistaAgregar.getNombreCliente().trim();
            String documento = vistaAgregar.getDocumento().trim();
            String placa = vistaAgregar.getPlaca().trim();
            String tipo = vistaAgregar.getTipoVehiculo();
            String modelo = vistaAgregar.getModelo().trim();
            LocalDateTime horaEntrada = LocalDateTime.now();

            if (nombre.isEmpty() || documento.isEmpty() || tipo.equals("Seleccione una opción") || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if ((tipo.contains("Automovil") || tipo.contains("Motocicleta")) && placa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La placa es obligatoria para automóviles y motocicletas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 🛡️ Verifica duplicados: placa/serie y documento
            String identificadorPrimario = (tipo.contains("Bicicleta") && placa.isEmpty()) ? documento : placa;
            if (parqueadero.existeVehiculoEnParqueadero(identificadorPrimario) || parqueadero.existeVehiculoEnParqueadero(documento)) {
                JOptionPane.showMessageDialog(null, "Ya hay un vehículo con esa placa, número de serie o documento en el parqueadero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            Vehiculo vehiculo = null;
            if (tipo.contains("Automovil")) {
                vehiculo = new Automovil(nombre, documento, modelo, tipo, placa);
            } else if (tipo.contains("Motocicleta")) {
                vehiculo = new Motocicleta(nombre, documento, modelo, tipo, placa);
            } else {
                if (placa.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Como la bicicleta no tiene placa o numero de serie, se usará el documento como identificador", "Información", JOptionPane.INFORMATION_MESSAGE);
                    placa = documento;
                    vehiculo = new Bicicleta(nombre, documento, modelo, tipo, placa);
                }else{
                    vehiculo = new Bicicleta(nombre, documento, modelo, tipo, placa);
                }

            }

            EspacioParqueo espacio = parqueadero.agregarVehiculo(vehiculo);

            if (espacio != null) {
                Ticket t = espacio.getTicket();
                ticketDao.crear(t);
                // Formatea la hora para la tabla
                String horaEntradaStr = horaEntrada.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                String placaTabla = "";
                if (vehiculo instanceof Automovil) {
                    Automovil auto = (Automovil) vehiculo;
                    placaTabla = auto.getPlaca();
                    autoDao.crear(auto);
                    clienteDao.crear(auto.getCliente());
                } else if (vehiculo instanceof Motocicleta) {
                    Motocicleta moto = (Motocicleta) vehiculo;
                    placaTabla = moto.getPlaca();
                    motoDao.crear(moto);
                    clienteDao.crear(moto.getCliente());
                } else if (vehiculo instanceof Bicicleta) {
                    Bicicleta bici = (Bicicleta) vehiculo;
                    placaTabla = bici.getNumeroSerie();
                    biciDao.crear(bici);
                    clienteDao.crear(bici.getCliente());

                }
                espacioParqueoDao.crear(espacio);



                // Agrega a la tabla de la vista principal
                vistaPrincipal.agregarVehiculoATabla(String.valueOf(t.getIdTicket()), placaTabla, vehiculo.getModelo(), vehiculo.getPropietario(), vehiculo.getTipo(), horaEntradaStr + " /");
                vistaPrincipal.setLbEspaciosDisponibles(String.valueOf(parqueadero.getEspaciosDisponibles()));
                vistaPrincipal.setLbEspaciosOcupados(String.valueOf(parqueadero.getEspaciosOcupados()));
                JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vistaAgregar.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No hay espacios disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    class SacarVehiculoListener implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = vistaSacar.getId().trim();
            String nombre = vistaSacar.getNombreCliente().trim();
            String documento = vistaSacar.getDocumento().trim();
            String placa = vistaSacar.getPlaca().trim();

            if (id.isEmpty() || nombre.isEmpty() || documento.isEmpty() || placa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                // Llamar a la función que maneja la salida del vehículo y actualiza la factura
                prepararFactura(id);

            }
        }


    }


    class VolverListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vistaPrincipal.cambiarVista(vistaPrincipal.getVistaPrincipal());
        }
    }

    class VolverListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vistaPrincipal.cambiarVista(vistaPrincipal.getVistaPrincipal());
        }
    }

    class VolverListener3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vistaPrincipal.cambiarVista(vistaSacar);
        }
    }
}
