package Model;

/**
 * Esta clse guarda la informacion del dueño del vehiculo
 */
public class Cliente {
    private String nombre;
    private int documento;

    /**
     *
     * @param nombre
     * @param documento
     */
    public Cliente(String nombre, String documento){
        setDocumento(documento);
        setNombre(nombre);
    }

    /**
     * Se guarda el nombre del cliente
     * @param nombre
     */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    /**
     * Se obtine el nombre del cliente
     * @return
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Se ingresa el documento del cliente
     * @param documento
     */
    public void setDocumento(String documento){
        this.documento=Integer.parseInt(documento);
    }

    /**
     * Se obtine el documento del cliente
     * @return
     */
    public int getDocumento(){
        return this.documento;
    }
}
