package model;

/**
 *
 * La clase donde guardan las caracteristicas de los vehiculos
 */
public abstract class Vehiculo {
    protected Cliente cliente;
    protected String modelo;
    protected String tipo;

    public Vehiculo(String propietario, String documentoPropietario, String modelo, String tipo) {
        this.cliente = new Cliente(propietario, documentoPropietario);
        this.modelo = modelo;
        this.tipo = tipo;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public String getPropietario() {
        return cliente.getNombre();
    }

    public String getDocumentoPropietario() {
        return cliente.getDocumento();
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }
}
