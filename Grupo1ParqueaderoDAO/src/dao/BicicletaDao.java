package dao;

import model.Bicicleta;

import java.util.List;

public interface BicicletaDao {
    void crear(Bicicleta bicicleta);
    Bicicleta leer(String numeroSerie);
    void actualizar(Bicicleta bicicleta);
    void eliminar(String numeroSerie);
    List<Bicicleta> leerTodos();
    void guardarTodos(List<Bicicleta> bicicletas);
}

