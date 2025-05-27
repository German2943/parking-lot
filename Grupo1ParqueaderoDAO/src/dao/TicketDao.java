package dao;
import model.Ticket;

import java.util.List;

public interface TicketDao {
    void crear(Ticket ticket);
    Ticket buscarPorId(int id);
    List<Ticket> leerTodos();
    void actualizar(Ticket ticket);
    void eliminar(int id);
}
