package dao;

import model.EspacioParqueo;
import model.Ticket;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EspacioParqueoDaoImpl implements EspacioParqueoDao{

    private final String rutaArchivo = "recursos/espacios_parqueo.csv";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<EspacioParqueo> leerTodos() {
        List<EspacioParqueo> espacios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 3); // Dividimos en 3 partes: numero, ocupado, resto(ticket o vacio)
                int numero = Integer.parseInt(partes[0]);
                boolean ocupado = Boolean.parseBoolean(partes[1]);
                EspacioParqueo espacio = new EspacioParqueo(numero);

                if (ocupado && partes.length > 2 && !partes[2].isEmpty()) {
                    // El resto es el CSV del Ticket
                    Ticket ticket = Ticket.fromCSV(partes[2]);
                    espacio.ocupar(ticket.getVehiculo());
                    espacio.setTicket(ticket);
                }
                espacios.add(espacio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return espacios;
    }

    @Override
    public void guardarTodos(List<EspacioParqueo> espacios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (EspacioParqueo espacio : espacios) {
                StringBuilder sb = new StringBuilder();
                sb.append(espacio.getNumero()).append(",");
                boolean ocupado = !espacio.estaDisponible();
                sb.append(ocupado).append(",");

                if (ocupado) {
                    Ticket ticket = espacio.getTicket();
                    sb.append(ticket.toCSV());
                }

                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crear(EspacioParqueo espacio) {
        // Para crear un espacio, simplemente leer todos, agregar y guardar
        List<EspacioParqueo> espacios = leerTodos();
        espacios.add(espacio);
        guardarTodos(espacios);
    }

    @Override
    public EspacioParqueo leer(int numero) {
        List<EspacioParqueo> espacios = leerTodos();
        for (EspacioParqueo e : espacios) {
            if (e.getNumero() == numero) return e;
        }
        return null;
    }

    @Override
    public void actualizar(EspacioParqueo espacio) {
        List<EspacioParqueo> espacios = leerTodos();
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getNumero() == espacio.getNumero()) {
                espacios.set(i, espacio);
                break;
            }
        }
        guardarTodos(espacios);
    }

    @Override
    public void eliminar(int numero) {
        List<EspacioParqueo> espacios = leerTodos();
        espacios.removeIf(e -> e.getNumero() == numero);
        guardarTodos(espacios);
    }
}

