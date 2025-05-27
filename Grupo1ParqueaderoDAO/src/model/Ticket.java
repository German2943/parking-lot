package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Genera el ticket con la informacion del vehiculo
 */
public class Ticket {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private double valorPagar;
    private static int contadorId = 1;
    private final int idTicket;

    public Ticket(Cliente cliente, Vehiculo vehiculo, LocalDateTime horaEntrada) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = horaEntrada;
        this.idTicket = contadorId++;
    }
    public Ticket(int idTicket, Cliente cliente, Vehiculo vehiculo, LocalDateTime horaEntrada, LocalDateTime horaSalida, double valorPagar) {
        this.idTicket = idTicket;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.valorPagar = valorPagar;

        // Importante: actualizar el contador para que no se repita el id
        if (idTicket >= contadorId) {
           contadorId = idTicket + 1;
        }
    }

    public static int getContador() {
        return contadorId;
    }

    public static void setContador(int nuevoValor) {
        contadorId = nuevoValor;
    }



    public void registrarSalida(LocalDateTime horaSalida, double tarifa) {
        this.horaSalida = horaSalida;
        this.valorPagar = calcularCosto(tarifa);
    }

    private double calcularCosto(double tarifa) {
        long horas = java.time.Duration.between(horaEntrada, horaSalida).toHours();
        return (horas + 1) * tarifa;
    }

    public int getIdTicket() {
        return idTicket;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public String toCSV() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String placaONumSerie = "";

        if (vehiculo instanceof Automovil) {
            placaONumSerie = ((Automovil) vehiculo).getPlaca();
        } else if (vehiculo instanceof Motocicleta) {
            placaONumSerie = ((Motocicleta) vehiculo).getPlaca();
        } else if (vehiculo instanceof Bicicleta) {
            placaONumSerie = ((Bicicleta) vehiculo).getNumeroSerie();
        }

        return idTicket + "," +
                cliente.getNombre() + "," +
                cliente.getDocumento() + "," +
                vehiculo.getModelo() + "," +
                vehiculo.getTipo() + "," +
                placaONumSerie + "," +
                horaEntrada.format(formatter) + "," +
                (horaSalida != null ? horaSalida.format(formatter) : "") + "," +
                valorPagar;
    }


    public static Ticket fromCSV(String linea) {
        String[] partes = linea.split(",", -1);
        int id = Integer.parseInt(partes[0]);
        String nombre = partes[1];
        String documento = partes[2];
        String modelo = partes[3];
        String tipo = partes[4];
        String placaONumSerie = partes[5];
        LocalDateTime horaEntrada = LocalDateTime.parse(partes[6], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime horaSalida = partes[7].isEmpty() ? null : LocalDateTime.parse(partes[7], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        double valor = Double.parseDouble(partes[8]);

        Cliente cliente = new Cliente(nombre, documento);
        Vehiculo vehiculo;

        if (tipo.equalsIgnoreCase("Automovil")) {
            vehiculo = new Automovil(nombre, documento, modelo, tipo, placaONumSerie);
        } else if (tipo.equalsIgnoreCase("Motocicleta")) {
            vehiculo = new Motocicleta(nombre, documento, modelo, tipo, placaONumSerie);
        } else { // Bicicleta
            vehiculo = new Bicicleta(nombre, documento, modelo, tipo, placaONumSerie);
        }

        return new Ticket(id, cliente, vehiculo, horaEntrada, horaSalida, valor);
    }



}
