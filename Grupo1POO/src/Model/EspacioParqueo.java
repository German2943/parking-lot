package Model;

/**
 * Controla los espacios de parqueo
 */
public class EspacioParqueo {
    private Vehiculo vehiculo;
    private int numeroEspacio;
    private Boolean estado;

    /**
     *
     * @param numeroEspacio
     */
    public EspacioParqueo(int numeroEspacio){
        this.numeroEspacio=numeroEspacio;
    }

    /**
     * Crea un vehículo según el tipo
     * @param nombre
     * @param documento
     * @param tipo
     * @param numeroEspacio
     */
    public void setVehiculo(String nombre, String documento, int tipo, int numeroEspacio){
        if(tipo==0){
            this.vehiculo=new Automovil(nombre,documento, numeroEspacio);
        }else if (tipo==1){
            this.vehiculo=new Motocicleta(nombre,documento, numeroEspacio);
        }else {
            this.vehiculo=new Bicicleta(nombre,documento, numeroEspacio);
        }
    }

    /**
     * Obtiene el número de espacio
     * @return
     */
    public int getNumeroEspacio(){
        return this.numeroEspacio;
    }

    /**
     * Obtiene el objeto de tipo Vehiculo
     * @return
     */
    public Vehiculo getVehiculo(){
        return this.vehiculo;
    }

    /**
     * hace que el vehículo sea nulo indicando que el espacio ahora está vacío
     */
    public void salidaVehiculo(){
        this.vehiculo=null;
    }


}
