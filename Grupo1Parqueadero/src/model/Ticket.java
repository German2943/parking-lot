package model;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Genera el ticket con la informacion del vehiculo
 */
public class Ticket {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private double valorPagar;

    public Ticket(Cliente cliente, Vehiculo vehiculo, LocalDateTime horaEntrada) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = horaEntrada;
    }

    public void registrarSalida(LocalDateTime horaSalida, double tarifa) {
        this.horaSalida = horaSalida;
        this.valorPagar = calcularCosto(tarifa);
    }

    private double calcularCosto(double tarifa) {
        long horas = java.time.Duration.between(horaEntrada, horaSalida).toHours();
        return (horas + 1) * tarifa;
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

}
