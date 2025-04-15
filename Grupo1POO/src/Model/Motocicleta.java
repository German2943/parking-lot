package Model;

/**
 * Se ingresan los datos de la motocicleta
 */
public class Motocicleta extends Vehiculo {



    /**
     *
     * @param nombre
     * @param documento
     */
    public Motocicleta (String nombre, String documento, int numeroEspacio){

        super( nombre, documento, numeroEspacio);
    }

    /**
     * Establece que es de tipo motocicleta
     */

    public void setTipo() {
        super.tipo=super.tiposPosibles[1];
    }




}
