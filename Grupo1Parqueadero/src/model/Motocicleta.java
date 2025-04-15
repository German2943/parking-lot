package model;

/**
 * Se ingresan los datos de la motocicleta
 */
public class Motocicleta extends Vehiculo {
    private String placa;

    public Motocicleta(String propietario, String documento, String modelo, String tipo, String placa) {
        super(propietario, documento, modelo, tipo);
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }
}
