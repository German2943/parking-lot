package dao;

import model.Motocicleta;

import java.util.List;

public interface MotocicletaDao {
    void crear(Motocicleta moto);
    Motocicleta leer(String placa);
    void actualizar(Motocicleta moto);
    void eliminar(String placa);
    List<Motocicleta> leerTodos();
    void guardarTodos(List<Motocicleta> motos);
}

