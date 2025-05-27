package dao;

import model.Cliente;

import java.io.*;
import java.util.*;

public class ClienteDaoImpl implements ClienteDao {

    private final String rutaArchivo = "recursos/clientes.csv";

    @Override
    public List<Cliente> leerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 2);
                if (partes.length == 2) {
                    String documento = partes[0];
                    String nombre = partes[1];
                    clientes.add(new Cliente(nombre, documento));
                }
            }
        } catch (FileNotFoundException e) {
            // Archivo no existe, devolver lista vacía
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void guardarTodos(List<Cliente> clientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Cliente cliente : clientes) {
                bw.write(cliente.getDocumento() + "," + cliente.getNombre());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crear(Cliente cliente) {
        List<Cliente> clientes = leerTodos();
        clientes.add(cliente);
        guardarTodos(clientes);
    }

    @Override
    public Cliente leer(String documento) {
        List<Cliente> clientes = leerTodos();
        for (Cliente c : clientes) {
            if (c.getDocumento().equals(documento)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Cliente cliente) {
        List<Cliente> clientes = leerTodos();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDocumento().equals(cliente.getDocumento())) {
                clientes.set(i, cliente);
                break;
            }
        }
        guardarTodos(clientes);
    }

    @Override
    public void eliminar(String documento) {
        List<Cliente> clientes = leerTodos();
        clientes.removeIf(c -> c.getDocumento().equals(documento));
        guardarTodos(clientes);
    }
}

