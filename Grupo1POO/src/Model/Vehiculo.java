package Model;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * La clase donde guardan las caracteristicas de los vehiculos
 */
public abstract class Vehiculo {
    protected String tipo;
    protected Cliente cliente;
    protected String[] tiposPosibles={"Automovil","Motocicleta","Bicicleta"};
    protected LocalTime horaEntrada;
    protected LocalTime horaSalida;
    protected String fechaIngreso;
    protected int duracion;
    private String placa;
    private int numeroEspacio;

    /**
     *
     * @param nombre
     * @param documento
     */
    public Vehiculo(String nombre, String documento, int numeroEspacio){
        setCliente(nombre, documento);
        setHoraEntrada();
        this.numeroEspacio=numeroEspacio;

    }

    /**
     * Obtiene el numero de espacio del vehiculo
     * @return
     */
    public int getNumeroEspacio(){
        return this.numeroEspacio;
    }

    /**
     * Se genera la hora en tiempo real
     */
    public void setHoraEntrada(){
        this.horaEntrada=LocalTime.now();
    }

    /**
     * Se obtiene la hora de entrada
     */
    public LocalTime getHoraEntrada(){
        return this.horaEntrada;
    }

    /**
     * Calcula el total a pagar
     * @param selection
     * @param tarifas
     * @return
     */
    public int TotalPagar(int selection, int[] tarifas){
        int precioBase=0;
        if (selection==0){
            precioBase=tarifas[0];
        } else if (selection==1) {
            precioBase=tarifas[1];
        }else {
            precioBase=tarifas[2];
        }
        setDuracion();
        int duración=getDuracion();
        return duración * precioBase;
    }
    /**
     * Se genera la hora de salida
     */

    public void setHoraSalida(){
        this.horaSalida=LocalTime.now();
    }

    /**
     * Se obtiene la hora de salida
     * @return
     */
    public LocalTime getHoraSalida(){
        return this.horaSalida;
    }
    public void setDuracion(){
        long duracion= ChronoUnit.HOURS.between(getHoraEntrada(),getHoraSalida());
        this.duracion=(int) Math.round(duracion);
    }

    /**
     * Se obtiene el tiempo que permanecio el auto en el parqueadero
     * @return
     */
    public int getDuracion(){
        return this.duracion;
    }


    /**
     * Obtiene el tipo de vehiculo
     * @param selection
     * @return
     */
    public String getTipo(int selection){
        String tipo=null;
        if (selection==0){
            tipo=this.tiposPosibles[0];
        }else if(selection==1){
            tipo=this.tiposPosibles[1];
        }else {
            tipo=this.tiposPosibles[2];
        }
        return tipo;
    }

    /**
     * Se crea un nuevo cliente
     * @param nombre
     * @param documento
     */
    public void setCliente(String nombre, String documento){

        this.cliente=new Cliente(nombre, documento);
    }

    /**
     * Se obtiene el cliente
     * @return
     */
    public Cliente getCliente(){
        return this.cliente;
    }

    /**
     * Obtiene la placa del automovil
     * @param placa
     */
    public void setPlaca(String placa){

        this.placa=placa;
    }

    /**
     * Obtiene la placa del automovil
     * @return
     */
    public String getPlaca(){
        return this.placa;
    }

}
