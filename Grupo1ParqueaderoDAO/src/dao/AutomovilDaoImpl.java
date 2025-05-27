package dao;

import model.Automovil;

import java.io.*;
import java.util.*;

public class AutomovilDaoImpl implements AutomovilDao {

    private final String rutaArchivo = "recursos/automoviles.csv";

    @Override
    public List<Automovil> leerTodos() {
        List<Automovil> automoviles = new ArrayList<>();
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
                    automoviles.add(new Automovil(propietario, documento, modelo, tipo, placa));
                }
            }
        } catch (FileNotFoundException e) {
            // Archivo no existe, retornar lista vacía
        } catch (IOException e) {
            e.printStackTrace();
        }
        return automoviles;
    }

    @Override
    public void guardarTodos(List<Automovil> automoviles) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Automovil auto : automoviles) {
                String linea = String.join(",",
                        auto.getPlaca(),
                        auto.getPropietario(),
                        auto.getDocumentoPropietario(),
                        auto.getModelo(),
                        auto.getTipo());
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crear(Automovil automovil) {
        List<Automovil> automoviles = leerTodos();
        automoviles.add(automovil);
        guardarTodos(automoviles);
    }

    @Override
    public Automovil leer(String placa) {
        List<Automovil> automoviles = leerTodos();
        for (Automovil auto : automoviles) {
            if (auto.getPlaca().equalsIgnoreCase(placa)) {
                return auto;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Automovil automovil) {
        List<Automovil> automoviles = leerTodos();
        for (int i = 0; i < automoviles.size(); i++) {
            if (automoviles.get(i).getPlaca().equalsIgnoreCase(automovil.getPlaca())) {
                automoviles.set(i, automovil);
                break;
            }
        }
        guardarTodos(automoviles);
    }

    @Override
    public void eliminar(String placa) {
        List<Automovil> automoviles = leerTodos();
        automoviles.removeIf(auto -> auto.getPlaca().equalsIgnoreCase(placa));
        guardarTodos(automoviles);
    }
}

