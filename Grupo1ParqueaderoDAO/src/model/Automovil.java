package model;

/**
 * Se ingresan los datos del automovil
 */
public class Automovil extends Vehiculo {
    private String placa;


    public Automovil(String propietario, String documento, String modelo, String tipo, String placa) {
        super(propietario, documento, modelo, tipo);
        this.placa = placa;

    }

    public String getPlaca() {
        return placa;
    }


}
