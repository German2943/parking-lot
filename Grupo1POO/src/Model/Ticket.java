package Model;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Genera el ticket con la informacion del vehiculo
 */
public class Ticket {
    private Vehiculo vehiculo;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private int duracion;
    private int numeroEspacio;
    private int TotalPagar;
    private int tipo;

    /**
     *
     * @param vehiculo
     */
    public Ticket(Vehiculo vehiculo, int numeroTicket, int tipo, int[] tarifas, int numeroEspacio){
        this.vehiculo=vehiculo;
        setHoraEntrada();
        setHoraSalida();
        this.tipo=tipo;
        this.numeroEspacio=numeroTicket;
        this.TotalPagar=this.vehiculo.TotalPagar(tipo, tarifas);
    }

    /**
     * Obtiene el nombre del tipo de vehiculo
     * @return
     */
    public String getTipo(){
        String Tipo;
        if (this.tipo==0){
            Tipo="Automovil";
        } else if (this.tipo==1) {
            Tipo="Motocicleta";
        }else {
            Tipo="Bicicleta";
        }
        return  Tipo;
    }

    /**
     * Obtiene el numero de un espacio
     * @return
     */
    public int getNumeroEspacio(){
        return this.numeroEspacio;
    }

    /**
     * Obtiene un objeto tipo vehiculo
     * @return
     */
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    /**
     * Obtiene el nombre del dueño del vehiculo
     * @return
     */
    public String getNombreCliente(){
        return getVehiculo().getCliente().getNombre();
    }
    /**
     * Establece la hora de entrada del vehiculo para el ticket
     */
    public void setHoraEntrada(){
        this.horaEntrada=vehiculo.getHoraEntrada();
    }

    /**
     * Obtiene la hora de entrada del vehiculo que se asigno en el ticket
     * @return
     */
    public LocalTime getHoraEntrada(){
        return this.horaEntrada;
    }

    /**
     * Establece la hora de salida del vehiculo en el ticket
     */
    public void setHoraSalida(){
        this.horaSalida=vehiculo.getHoraSalida();
    }

    /**
     * Obtiene la hora de salida
     * @return
     */
    public LocalTime getHoraSalida(){
        return this.horaSalida;
    }

    /**
     * Establece en el ticket el tiempo que permanecio el vehiculo en el parqueadero
     */

}
