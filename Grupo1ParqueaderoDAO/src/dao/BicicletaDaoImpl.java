package dao;

import model.Bicicleta;

import java.io.*;
import java.util.*;

public class BicicletaDaoImpl implements BicicletaDao {

    private final String rutaArchivo = "recursos/bicicletas.csv";

    @Override
    public List<Bicicleta> leerTodos() {
        List<Bicicleta> bicicletas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 5);
                if (partes.length == 5) {
                    String numeroSerie = partes[0];
                    String propietario = partes[1];
                    String documento = partes[2];
                    String modelo = partes[3];
                    String tipo = partes[4];
                    bicicletas.add(new Bicicleta(propietario, documento, modelo, tipo, numeroSerie));
                }
            }
        } catch (FileNotFoundException e) {
            // Archivo no existe, retornar lista vacía
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bicicletas;
    }

    @Override
    public void guardarTodos(List<Bicicleta> bicicletas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Bicicleta bici : bicicletas) {
                String linea = String.join(",",
                        bici.getNumeroSerie(),
                        bici.getPropietario(),
                        bici.getDocumentoPropietario(),
                        bici.getModelo(),
                        bici.getTipo());
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crear(Bicicleta bicicleta) {
        List<Bicicleta> bicicletas = leerTodos();
        bicicletas.add(bicicleta);
        guardarTodos(bicicletas);
    }

    @Override
    public Bicicleta leer(String numeroSerie) {
        List<Bicicleta> bicicletas = leerTodos();
        for (Bicicleta bici : bicicletas) {
            if (bici.getNumeroSerie().equalsIgnoreCase(numeroSerie)) {
                return bici;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Bicicleta bicicleta) {
        List<Bicicleta> bicicletas = leerTodos();
        for (int i = 0; i < bicicletas.size(); i++) {
            if (bicicletas.get(i).getNumeroSerie().equalsIgnoreCase(bicicleta.getNumeroSerie())) {
                bicicletas.set(i, bicicleta);
                break;
            }
        }
        guardarTodos(bicicletas);
    }

    @Override
    public void eliminar(String numeroSerie) {
        List<Bicicleta> bicicletas = leerTodos();
        bicicletas.removeIf(bici -> bici.getNumeroSerie().equalsIgnoreCase(numeroSerie));
        guardarTodos(bicicletas);
    }
}

