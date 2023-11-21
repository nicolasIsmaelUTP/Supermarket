package com.nibble.supermarket.servicios;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.dao.exceptions.NonexistentEntityException;
import com.nibble.supermarket.modelo.Producto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoServicio implements IServicio<Producto,Integer>{

    // Implementación de los métodos CRUD
    
    @Override
    public void guardar(Producto entidad) {
        DaoManager.getInstance().getProductoDao().create(entidad);
    }

    @Override
    public void actualizar(Producto entidad) {
        try {
            DaoManager.getInstance().getProductoDao().edit(entidad);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            DaoManager.getInstance().getProductoDao().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProductoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Producto buscarPorId(Integer id) {
        return DaoManager.getInstance().getProductoDao().findProducto(id);
    }

    @Override
    public List<Producto> buscarTodos() {
        return DaoManager.getInstance().getProductoDao().findProductoEntities();
    }
    
}
