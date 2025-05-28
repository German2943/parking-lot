package dao;
import java.io.*;
import java.util.ArrayList;
public class Historial {
    private ArrayList<String> ids =new ArrayList<>();
    public Historial(){

    }

    public ArrayList<String> getIds() {
        return this.ids;
    }

    public void setIds(ArrayList<String> ids) {
        this.ids = ids;
    }

    public void añadir(String line){
        //ID,Placa,TipoVehiculo,FechaHoraIngreso, FechaHoraSalida, EspacioAsignado
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
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }



            // Escribir datos en nueva línea
            if (!getIds().contains(id[0])){
                out.println(line);
            }


        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
