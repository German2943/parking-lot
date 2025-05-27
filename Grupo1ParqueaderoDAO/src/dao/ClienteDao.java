package dao;

import model.Cliente;

import java.util.List;

public interface ClienteDao {
    void crear(Cliente cliente);
    Cliente leer(String documento);
    void actualizar(Cliente cliente);
    void eliminar(String documento);
    List<Cliente> leerTodos();
    void guardarTodos(List<Cliente> clientes);
}

