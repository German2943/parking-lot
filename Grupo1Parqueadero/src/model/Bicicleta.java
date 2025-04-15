package model;

/**
 * Se ingresan los datos de Bicicleta
 */
public class Bicicleta extends Vehiculo{
    private String numeroSerie;
    public Bicicleta(String propietario, String documento, String modelo, String tipo, String numeroSerie) {
        super(propietario, documento, modelo, tipo);
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }
}
