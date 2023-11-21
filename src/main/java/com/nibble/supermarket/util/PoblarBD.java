package com.nibble.supermarket.util;

import com.nibble.supermarket.modelo.Cliente;
import com.nibble.supermarket.servicios.ClienteServicio;

public class PoblarBD {

    private static final ClienteServicio clientes = new ClienteServicio();
    //private static final ProductoServicio productos = new ProductoServicio();

    public static void poblarBD() {
        poblarClientes();
    }

    private static void poblarClientes() {
        if (clientes.buscarTodos().isEmpty()) {
            clientes.guardar(new Cliente("12345678A", "Juan", "Pérez", "García", "González", 25));
            clientes.guardar(new Cliente("87654321B", "María", "García", "Pérez", "González", 30));
        }
    }

}
