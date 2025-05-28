package dao;
import java.io.*;
import java.util.ArrayList;
public class Historial {
    private ArrayList<String> ids =new ArrayList<>();
    private String temporalEntrada;
    private String temporalSalida=" ";
    private ArrayList<String> lines=new ArrayList<>();

    public Historial(){

    }

    public ArrayList<String> getLines() {
        return this.lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }

    public String getTemporalEntrada() {
        return this.temporalEntrada;
    }

    public void setTemporalEntrada(String temporalEntrada) {
        this.temporalEntrada = temporalEntrada;
    }

    public String getTemporalSalida() {
        return this.temporalSalida;
    }

    public void setTemporalSalida(String temporalSalida) {
        this.temporalSalida = temporalSalida;
    }

    public ArrayList<String> getIds() {
        return this.ids;
    }

    public void setIds(ArrayList<String> ids) {
        this.ids = ids;
    }

    public void agregarHistorial(boolean sobreescribir){
        try (BufferedReader br = new BufferedReader(new FileReader("recursos/tickets.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes=linea.split(",");
                String lineaFinal=partes[0]+","+partes[5]+","+partes[4]+","+partes[6]+","+partes[7]+","+partes[0];
                añadir(lineaFinal, sobreescribir);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void añadir(String line, boolean sobreescribir){
        //ID,Placa,TipoVehiculo,FechaHoraIngreso, FechaHoraSalida, EspacioAsignado
        int indexBuscar=0;
        String[] id=line.split(",");
        String ruta="recursos/historial_parqueadero.csv";
        File archivo=new File(ruta);
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {



            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    getIds().add(linea.split(",")[0]);
                    getLines().add(linea);
                    if (linea.split(",")[0].equalsIgnoreCase(id[0])){
                        indexBuscar=getIds().indexOf(id[0]);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }



            // Escribir datos en nueva línea
            if (!getIds().contains(id[0])){
                out.println(line);
            } else if (sobreescribir) {
                if(indexBuscar<getLines().size()){
                    getLines().set(indexBuscar,line);
                    try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
                        for (String lineaAux : getLines()) {
                            pw.println(lineaAux);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }


        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
