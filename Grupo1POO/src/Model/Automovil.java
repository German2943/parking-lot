package Model;

/**
 * Se ingresan los datos del automovil
 */
public class Automovil extends Vehiculo {


    /**
     *
     * @param nombre
     * @param documento
     */
    public Automovil(String nombre, String documento, int numeroEspacio){

        super( nombre, documento, numeroEspacio);
    }

    /**
     * Establece que es de tipo automovil
     */

    public void setTipo() {

        super.tipo=super.tiposPosibles[0];
    }




}
