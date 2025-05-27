package dao;

import model.Motocicleta;

import java.io.*;
import java.util.*;

public class MotocicletaDaoImpl implements MotocicletaDao {

    private final String rutaArchivo = "recursos/motocicletas.csv";

    @Override
    public List<Motocicleta> leerTodos() {
        List<Motocicleta> motos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 5);
                if (partes.length == 5) {
                    String placa = partes[0];
                    String propietario = partes[1];
                    String documento = partes[2];
                    String modelo = partes[3];
                    String tipo = partes[4];
                    motos.add(new Motocicleta(propietario, documento, modelo, tipo, placa));
                }
            }
        } catch (FileNotFoundException e) {
            // Archivo no existe, se devuelve lista vacía
        } catch (IOException e) {
            e.printStackTrace();
        }
        return motos;
    }

    @Override
    public void guardarTodos(List<Motocicleta> motos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Motocicleta moto : motos) {
                String linea = String.join(",",
                        moto.getPlaca(),
                        moto.getPropietario(),
                        moto.getDocumentoPropietario(),
                        moto.getModelo(),
                        moto.getTipo());
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crear(Motocicleta moto) {
        List<Motocicleta> motos = leerTodos();
        motos.add(moto);
        guardarTodos(motos);
    }

    @Override
    public Motocicleta leer(String placa) {
        List<Motocicleta> motos = leerTodos();
        for (Motocicleta moto : motos) {
            if (moto.getPlaca().equalsIgnoreCase(placa)) {
                return moto;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Motocicleta moto) {
        List<Motocicleta> motos = leerTodos();
        for (int i = 0; i < motos.size(); i++) {
            if (motos.get(i).getPlaca().equalsIgnoreCase(moto.getPlaca())) {
                motos.set(i, moto);
                break;
            }
        }
        guardarTodos(motos);
    }

    @Override
    public void eliminar(String placa) {
        List<Motocicleta> motos = leerTodos();
        motos.removeIf(moto -> moto.getPlaca().equalsIgnoreCase(placa));
        guardarTodos(motos);
    }
}

