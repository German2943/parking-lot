package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Controla los estados de los espacios de parqueo y la circulacion de vehiculos
 */
public class Parqueadero {
    private List<EspacioParqueo> espacios;
    private List<Ticket> historialVehiculos;
    private Map<String, Double> tarifas; // Tarifa por hora

    public Parqueadero(int capacidad, Map<String, Double> tarifas) {
        this.espacios = new ArrayList<>();
        this.historialVehiculos = new ArrayList<>();
        this.tarifas = tarifas; // La tarifa puede ser configurada al crear el parqueadero
        for (int i = 0; i < capacidad; i++) {
            espacios.add(new EspacioParqueo(i + 1));
        }
    }

    // Método para agregar un vehículo y asignar un espacio de parqueo
    public EspacioParqueo agregarVehiculo(Vehiculo vehiculo) {
        for (EspacioParqueo espacio : espacios) {
            if (espacio.estaDisponible()) {
                espacio.ocupar(vehiculo);
                // Suponemos que el vehículo ha entrado al parqueadero, y lo asociamos con un ticket
                LocalDateTime horaEntrada = LocalDateTime.now();
                Ticket ticket = new Ticket(vehiculo.getCliente(), vehiculo, horaEntrada);
                espacio.setTicket(ticket);
                historialVehiculos.add(ticket);
                return espacio; // Retorna el espacio donde se ha estacionado el vehículo
            }
        }
        return null; // No hay espacios disponibles
    }

    public Ticket darSalidaVehiculoPorIdentificador(String identificador, LocalDateTime horaSalida) {
        for (EspacioParqueo espacio : espacios) {
            if (!espacio.estaDisponible()) {
                Vehiculo vehiculo = espacio.getVehiculo();
                Ticket ticket = espacio.getTicket();

                if (vehiculo != null && ticket != null) {
                    boolean coincide = false;

                    // Buscar por placa (Automóvil o Motocicleta)
                    if (vehiculo instanceof Automovil) {
                        coincide = ((Automovil) vehiculo).getPlaca().equalsIgnoreCase(identificador);
                    } else if (vehiculo instanceof Motocicleta) {
                        coincide = ((Motocicleta) vehiculo).getPlaca().equalsIgnoreCase(identificador);
                    }else if (vehiculo instanceof Bicicleta) {
                        coincide = ((Bicicleta) vehiculo).getNumeroSerie().equalsIgnoreCase(identificador);
                    }

                    // Buscar por documento (para todos los vehículos)
                    coincide = coincide || vehiculo.getCliente().getDocumento().equalsIgnoreCase(identificador);

                    // Si coincide por placa o documento
                    if (coincide) {
                        // Calcular tarifa
                        double tarifa = tarifas.getOrDefault(vehiculo.getTipo(), 1000.0); // Tarifa por defecto si no está configurada
                        ticket.registrarSalida(horaSalida, tarifa);

                        // Liberar el espacio
                        espacio.liberar();

                        return ticket;
                    }
                }
            }
        }
        return null; // No se encontró vehículo con ese identificador
    }


    public Ticket buscarTicketPorPlacaOPropietario(String placa, String nombre, String documento) {
        for (EspacioParqueo espacio : espacios) {
            if (!espacio.estaDisponible() && espacio.getVehiculo() != null) {
                Vehiculo vehiculo = espacio.getVehiculo();
                String idVehiculo = (vehiculo instanceof Bicicleta) ? ((Bicicleta) vehiculo).getNumeroSerie()
                        : ((Automovil.class.isInstance(vehiculo)) ? ((Automovil) vehiculo).getPlaca()
                        : ((Motocicleta) vehiculo).getPlaca());

                if (idVehiculo.equals(placa) & vehiculo.getCliente().getNombre().equalsIgnoreCase(nombre)
                        & vehiculo.getCliente().getDocumento().equals(documento)) {
                    return espacio.getTicket();
                }
            }
        }
        return null;
    }
    public boolean existeVehiculoEnParqueadero(String identificador) {
        for (EspacioParqueo espacio : espacios) {
            if (!espacio.estaDisponible()) {
                Vehiculo vehiculo = espacio.getVehiculo();
                if (vehiculo instanceof Automovil) {
                    if (((Automovil) vehiculo).getPlaca().equalsIgnoreCase(identificador)) {
                        return true;
                    }
                } else if (vehiculo instanceof Motocicleta) {
                    if (((Motocicleta) vehiculo).getPlaca().equalsIgnoreCase(identificador)) {
                        return true;
                    }
                }else if (vehiculo instanceof Bicicleta) {
                    if (((Bicicleta) vehiculo).getNumeroSerie().equalsIgnoreCase(identificador)) {
                        return true;
                    }
                }

                if (vehiculo.getCliente().getDocumento().equalsIgnoreCase(identificador)) {
                    return true;
                }
            }
        }
        return false;
    }

    public double calcularValorPorTicket(Ticket ticket, LocalDateTime horaSalida) {
        String tipo = ticket.getVehiculo().getTipo();
        double tarifa = tarifas.getOrDefault(tipo, 0.0);
        Duration duracion = Duration.between(ticket.getHoraEntrada(), horaSalida);
        long minutos = duracion.toMinutes();
        return (minutos / 60.0) * tarifa;
    }

    public List<Ticket> getTicketsFiltrados(String tipoVehiculo, boolean soloEnParqueadero) {
        List<Ticket> filtrados = new ArrayList<>();

        for (Ticket ticket : historialVehiculos) {
            Vehiculo vehiculo = ticket.getVehiculo();

            boolean coincideTipo = (tipoVehiculo == null || vehiculo.getTipo().equals(tipoVehiculo));
            boolean estaEnParqueadero = ticket.getHoraSalida() == null;

            if (coincideTipo && (!soloEnParqueadero || estaEnParqueadero)) {
                filtrados.add(ticket);
            }
        }

        return filtrados;
    }


    // Método para obtener el número de espacios disponibles
    public int getEspaciosDisponibles() {
        int disponibles = 0;
        for (EspacioParqueo espacio : espacios) {
            if (espacio.estaDisponible()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    // Método para obtener el número de espacios ocupados
    public int getEspaciosOcupados() {
        int ocupados = 0;
        for (EspacioParqueo espacio : espacios) {
            if (!espacio.estaDisponible()) {
                ocupados++;
            }
        }
        return ocupados;
    }

}
