package Model;

import java.util.ArrayList;
import java.time.LocalTime;
/**
 * Controla los estados de los espacios de parqueo y la circulacion de vehiculos
 */
public class Parqueadero {
    final int[] limites={100,100,100};
    private  final int[] tarifas={100,50,30};
    final String[] tipos={"Automovil", "Motocicleta", "Bicicleta"};
    final int limiteAutos=limites[0];
    final int limiteMotos=limites[1];
    final int limiteBicis=limites[2];
    private int espacioAuto=0;
    private int espacioMoto=0;
    private int espacioBici=0;
    private int contadorVehiculo =0;
    private ArrayList<EspacioParqueo> espaciosAuto=new ArrayList<>();
    private ArrayList<EspacioParqueo> espaciosMoto=new ArrayList<>();
    private ArrayList<EspacioParqueo> espaciosBici=new ArrayList<>();
    private ArrayList<ArrayList<EspacioParqueo>> espaciosParqueo=new ArrayList<>();
    private ArrayList<Vehiculo> registro=new ArrayList<>();
    private int generadorTicket=1;
    private ArrayList<Integer> indicesOcupadosAutos=new ArrayList<>();
    private ArrayList<Integer> indicesOcupadosMotos=new ArrayList<>();
    private ArrayList<Integer> indicesOcupadosBicis=new ArrayList<>();
    private int ingresos=0;
    private ArrayList<Integer> documentos=new ArrayList<>();
    private int contadorSalidas=0;
    private int contadorEntradas=0;
    private Ticket ticket;



    /** Cuando se cree una instancia de la clase, automáticamente se cearán los arrays
     * de cada tipo de espacio de parqueo **/
    public Parqueadero(){
        this.espaciosParqueo.add(0, espaciosAuto);
        this.espaciosParqueo.add(1, espaciosMoto);
        this.espaciosParqueo.add(2, espaciosBici);
        for (int indexTiposEspacio=0; indexTiposEspacio<this.limites.length; indexTiposEspacio++){
            for (int indexEspacio=0; indexEspacio<=this.limites[indexTiposEspacio]; indexEspacio++){
                this.espaciosParqueo.get(indexTiposEspacio).add(indexEspacio, new EspacioParqueo(indexEspacio));
            }
        }

    }

    /**
     * Para obtener los documentos almacenados en el ArrayList
     * @return
     */
    public ArrayList<Integer> getDocumentos(){
        return this.documentos;
    }


    /**
     * Comprueba que el documento no exista ya en la lista
     * @param documento
     * @return
     */
    public Boolean existeDocumento(int documento){
        Boolean existe=false;
        if (getDocumentos().contains(documento)){
            existe=true;
        }
        return existe;
    }

    /**
     * Obtiene los espacios ocupados en el parqueadero y los almacena en un ArraList
     * @param tipo
     * @return
     */
    public ArrayList<Integer> getIndicesOcupados(int tipo){
        ArrayList<Integer> espacio=new ArrayList<>();
        if(tipo==0){
            espacio=this.indicesOcupadosAutos;
        } else if (tipo==1) {
            espacio=this.indicesOcupadosMotos;
        }else {
            espacio=this.indicesOcupadosBicis;
        }
        return espacio;
    }

    /**
     * Prueba si que el parqueadero este lleno
     * @param tipo
     * @return
     */
    public Boolean parqueaderoLLeno(int tipo){
        Boolean full=false;
        int contador=0;
        for (int indexEspacio=0; indexEspacio<getLimites(tipo); indexEspacio++) {

            if (getEspacio(tipo).get(indexEspacio).getVehiculo() != null) {
                contador++;
                getIndicesOcupados(tipo).add(indexEspacio);
            }
        }
        if ((contador)==getEspacio(tipo).size()){
            full=true;
        }
        return full;
    }

    /**
     * Prueba si el parqueadero esta vacio
     * @param tipo
     * @return
     */
    public Boolean parqueaderoVacio(int tipo){
        Boolean empty=false;
        int contador=0;
        for (int indexEspacio=0; indexEspacio<getEspacio(tipo).size(); indexEspacio++) {

            if (getEspacio(tipo).get(indexEspacio).getVehiculo() == null) {
                contador++;
                getIndicesOcupados(tipo).remove(indexEspacio);
            }
        }
        if ((contador)==getEspacio(tipo).size()){
            empty=true;
        }
        return empty;
    }

    /**
     * Para obtener el numero del ticket
     * @return
     */
    public int getGeneradorTicket(){
        return this.generadorTicket;
    }

    /**
     * Obtiene las tarifas
     * @return
     */
    public int[] getTarifas(){
        return this.tarifas;
    }

    /**
     * Obtiene los ingresos totales
     * @return
     */
    public int IngresosTotales(){
        return this.ingresos;
    }

    /**
     * Ingresa el numero de vehiculos que han ingresado
     */
    public  void setContadorEntradas(){
        this.contadorEntradas=getContadorVehiculo();
    }

    /**
     * Obtiene el numero de vehiculos que han ingresado
     * @return
     */
    public int getContadorEntradas(){
        return this.contadorEntradas;
    }

    /**
     * Genera el numero de vehiculos que han salido
     */
    public void setContadorSalidas(){
        this.contadorSalidas++;
    }

    /**
     * Obtiene el numero de vehiculos que han salido
     * @return
     */
    public int getContadorSalidas(){
        return this.contadorSalidas;
    }

    /**
     * Obtiene el contador de vehiculos que han ingresado
     * @return
     */
    public int getContadorVehiculo(){
        return this.contadorVehiculo;
    }

    /**
     * Genera el numero de vehiculos que han ingresado
     */
    public void setContadorVehiculo(){
        this.contadorVehiculo++;
    }

    /**
     * Obtiene el registro de vehiculos de parqueadero
     * @return
     */
    public ArrayList<Vehiculo> getRegistro(){
        return this.registro;
    }

    /**
     * Obtiene el tipo de vehiculo que hay en un espacio del parqueadero
     * @param selection
     * @return
     */
    public int getEspacioNumero(int selection){
        int espacioNumero=0;
        if (selection==0){
            espacioNumero=this.espacioAuto;
        }else if (selection==1){
            espacioNumero=this.espacioMoto;
        }else {
            espacioNumero=this.espacioBici;
        }
        return espacioNumero;
    }

    /**
     * Genera el numero numero de vehiculos que hay de cada tipo
     * @param selection
     */
    public void setEspacioNumero(int selection){
        if (selection==0){
            this.espacioAuto++;
        }else if (selection==1){
            this.espacioMoto++;
        }else {
            this.espacioBici++;
        }

    }


    /**
     * Obtiene el limite de espacios de cada vehiculo
     * @param selection
     * @return
     */
    public int getLimites(int selection){
        int limite =0;
        if(selection==0){
            limite =this.limiteAutos;
        }else if (selection==1){
            limite =this.limiteMotos;
        }else {
            limite =this.limiteBicis;
        }
        return limite;
    }

    /**
     * Obtiene los espacios ocupados en el parqueadro
     * @return
     */
    public int getEspaciosOcupados(){
        return getContadorVehiculo();
    }

    /**
     * Obtiene los espcaios disponibles en el parueadero
     * @return
     */
    public int getEspaciosDisponibles(){
        return ((limites[0]+limites[1]+limites[2])-getContadorVehiculo());
    }

    /**
     * Obtiene el tipo de vehiculo
     * @return
     */
    public String[] getTipos(){
        return this.tipos;
    }

    /**
     * Obtiene el numero de espacios de parqueo de los autos
     * @return
     */
    public ArrayList<EspacioParqueo> getEspaciosAuto(){
        return this.espaciosAuto;
    }

    /**
     * Obtiene el numero de espacios de parqueo de las motos
     * @return
     */
    public ArrayList<EspacioParqueo> getEspaciosMoto(){
        return this.espaciosMoto;
    }

    /**
     * Obtiene el numero de espacios de la bicicleta
     * @return
     */
    public ArrayList<EspacioParqueo> getEspaciosBici(){
        return this.espaciosBici;
    }

    /**
     * Obtiene el espacio donde se guardara el vehiculo
     * @param selectionType
     * @return
     */
    public ArrayList<EspacioParqueo> getEspacio(int selectionType){
        ArrayList<EspacioParqueo> espacio=null;
        if (selectionType==0){
            espacio=getEspaciosAuto();
        } else if (selectionType==1) {
            espacio=getEspaciosMoto();
        }else {
            espacio=getEspaciosBici();
        }
        return espacio;
    }

    /**
     * Obtiene el tipo de vehiculo que hay en un espacio especifico
     * @param tipo
     * @param numeroEspacio
     * @return
     */
    public Vehiculo getVehiculo(int tipo, int numeroEspacio){
        Vehiculo vehiculo=null;
        if(tipo==0){
            vehiculo=getEspaciosAuto().get(numeroEspacio).getVehiculo();
        }else if (tipo==1){
            vehiculo=getEspaciosMoto().get(numeroEspacio).getVehiculo();
        }else {
            vehiculo=getEspaciosBici().get(numeroEspacio).getVehiculo();
        }
        return vehiculo;
    }

    /**
     * Ingresa el vehiculo al parqueadero
     * @param tipo
     * @param nombre
     * @param documento
     */
    public void ingresarVehiculo(int tipo, String nombre, String documento){

        for (int indexEspacio=0; indexEspacio<getEspacio(tipo).size(); indexEspacio++){

            if (getEspacio(tipo).get(indexEspacio).getVehiculo()==null){

                getEspacio(tipo).get(getEspacioNumero(tipo)).setVehiculo(nombre, documento, tipo, indexEspacio);
                getRegistro().add(getContadorVehiculo(),getEspacio(tipo).get(getEspacioNumero(tipo)).getVehiculo());
                setContadorVehiculo();
                setContadorEntradas();
                getDocumentos().add(Integer.parseInt(documento));
                if (indexEspacio==(getEspacio(tipo).size()-1)){
                    setEspacioNumero(tipo);
                }
                break;
            }
        }
    }

    /**
     * Obtiene el ticket
     * @return
     */
    public Ticket getTicket(){
        return this.ticket;
    }

    /**
     * Registra hora de la salida de los vehiculos
     * @param tipo
     * @param numeroEspacio
     * @return
     */
    public LocalTime salidaVehiculo(int tipo, int numeroEspacio){
        getRegistro().add(getEspacio(tipo).get(numeroEspacio).getVehiculo());
        getEspacio(tipo).get(numeroEspacio).getVehiculo().setHoraSalida();
        LocalTime horaSalida=getEspacio(tipo).get(numeroEspacio).getVehiculo().getHoraSalida();

        this.ingresos=this.ingresos+getEspacio(tipo).get(numeroEspacio).getVehiculo().TotalPagar(tipo, this.tarifas);
        this.ticket=new Ticket(getEspacio(tipo).get(numeroEspacio).getVehiculo(),this.generadorTicket,tipo,this.tarifas,numeroEspacio);
        this.generadorTicket++;
        getEspacio(tipo).get(numeroEspacio).salidaVehiculo();
        setContadorSalidas();

        return horaSalida;
    }






}
