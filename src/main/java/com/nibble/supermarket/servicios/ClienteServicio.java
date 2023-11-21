
package com.nibble.supermarket.servicios;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.dao.exceptions.NonexistentEntityException;
import com.nibble.supermarket.modelo.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteServicio implements IServicio<Cliente, String>{

    // Implementación de los métodos CRUD

    @Override
    public void guardar(Cliente entidad) {
        try {
            DaoManager.getInstance().getClienteDao().create(entidad);
        } catch (Exception ex) {
            Logger.getLogger(ClienteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(Cliente entidad) {
        try {
            DaoManager.getInstance().getClienteDao().edit(entidad);
        } catch (Exception ex) {
            Logger.getLogger(ClienteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(String id) {
        try {
            DaoManager.getInstance().getClienteDao().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente buscarPorId(String id) {
        return DaoManager.getInstance().getClienteDao().findCliente(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return DaoManager.getInstance().getClienteDao().findClienteEntities();
    }

    // Otros métodos de la clase ClienteServicio
    
    public boolean existeCliente(String id) {
        Cliente cliente = buscarPorId(id);
        return cliente != null;
    }
}
