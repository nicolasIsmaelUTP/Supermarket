package com.nibble.supermarket.servicios;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.dao.exceptions.NonexistentEntityException;
import java.util.List;

import com.nibble.supermarket.modelo.Promocion;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromocionServicio implements IServicio<Promocion,Integer>{

    @Override
    public void guardar(Promocion entidad) {
        DaoManager.getInstance().getPromocionDao().create(entidad);
    }

    @Override
    public void actualizar(Promocion entidad) {
        try {
            DaoManager.getInstance().getPromocionDao().edit(entidad);
        } catch (Exception ex) {
            Logger.getLogger(PromocionServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            DaoManager.getInstance().getPromocionDao().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PromocionServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Promocion buscarPorId(Integer id) {
        return DaoManager.getInstance().getPromocionDao().findPromocion(id);
    }

    @Override
    public List<Promocion> buscarTodos() {
        return DaoManager.getInstance().getPromocionDao().findPromocionEntities();
    }
    
}
