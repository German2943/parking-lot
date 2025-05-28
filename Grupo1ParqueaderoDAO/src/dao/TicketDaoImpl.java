package dao;

import model.Ticket;

import java.io.*;
import java.nio.file.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TicketDaoImpl implements TicketDao {
    private static final String ARCHIVO = "recursos/tickets.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void crear(Ticket ticket) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARCHIVO, true))) {
            out.println(ticket.toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Ticket buscarPorId(int id) {
        return leerTodos().stream()
                .filter(t -> t.getIdTicket() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Ticket> leerTodos() {
        List<Ticket> lista = new ArrayList<>();
        if (!Files.exists(Path.of(ARCHIVO))) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lista.add(Ticket.fromCSV(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Ticket ticketActualizado) {
        List<Ticket> lista = leerTodos();
        try (PrintWriter out = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Ticket t : lista) {
                if (t.getIdTicket() == ticketActualizado.getIdTicket()) {
                    out.println(ticketActualizado.toCSV());
                } else {
                    out.println(t.toCSV());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Historial historial=new Historial();
        historial.agregarHistorial(true);

    }

    @Override
    public void eliminar(int id) {
        List<Ticket> lista = leerTodos();
        try (PrintWriter out = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Ticket t : lista) {
                if (t.getIdTicket() != id) {
                    out.println(t.toCSV());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
