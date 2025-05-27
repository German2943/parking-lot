package model;

/**
 * Controla los espacios de parqueo
 */
public class EspacioParqueo {
    private int numero;
    private Vehiculo vehiculo;
    private Ticket ticket;

    public EspacioParqueo(int numero) {
        this.numero = numero;
        this.vehiculo = null;
        this.ticket = null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public Ticket getTicket() {
        return ticket;
    }

    public int getNumero() {
        return numero;
    }

    public boolean estaDisponible() {
        return vehiculo == null;
    }

    public void ocupar(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void liberar() {
        this.vehiculo = null;
        this.ticket = null;
    }

    public Vehiculo getVehiculo() {
        return vehiculo; // Metodo para obtener el vehículo dentro del espacio
    }
}
