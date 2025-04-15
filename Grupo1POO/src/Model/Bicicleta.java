package Model;

/**
 * Se ingresan los datos de Bicicleta
 */
public class Bicicleta extends Vehiculo{

    /**
     *
     * @param nombre
     * @param documento
     */
    public Bicicleta(String nombre, String documento, int numeroEspacio){

        super( nombre, documento, numeroEspacio);
    }

    /**
     * Establece que es de tipo bicicleta
     */

    public void setTipo() {
        super.tipo=super.tiposPosibles[2];
    }

}
