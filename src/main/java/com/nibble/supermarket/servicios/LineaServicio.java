package com.nibble.supermarket.servicios;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.dao.exceptions.NonexistentEntityException;
import com.nibble.supermarket.modelo.Linea;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LineaServicio implements IServicio<Linea, Integer>{

    @Override
    public void guardar(Linea entidad) {
        DaoManager.getInstance().getLineaDao().create(entidad);
    }

    @Override
    public void actualizar(Linea entidad) {
        try {
            DaoManager.getInstance().getLineaDao().edit(entidad);
        } catch (Exception ex) {
            Logger.getLogger(LineaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            DaoManager.getInstance().getLineaDao().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(LineaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Linea buscarPorId(Integer id) {
        return DaoManager.getInstance().getLineaDao().findLinea(id);
    }

    @Override
    public List<Linea> buscarTodos() {
        return DaoManager.getInstance().getLineaDao().findLineaEntities();
    }
    
}
