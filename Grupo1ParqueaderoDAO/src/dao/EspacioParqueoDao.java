package dao;

import model.EspacioParqueo;

import java.util.List;

public interface EspacioParqueoDao {
    void crear(EspacioParqueo espacio);
    EspacioParqueo leer(int numero);
    void actualizar(EspacioParqueo espacio);
    void eliminar(int numero);
    List<EspacioParqueo> leerTodos();
    void guardarTodos(List<EspacioParqueo> espacios);
}

