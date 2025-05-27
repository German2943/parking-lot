package dao;

import model.Automovil;

import java.util.List;

public interface AutomovilDao {
    void crear(Automovil automovil);
    Automovil leer(String placa);
    void actualizar(Automovil automovil);
    void eliminar(String placa);
    List<Automovil> leerTodos();
    void guardarTodos(List<Automovil> automoviles);
}

