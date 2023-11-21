package com.nibble.supermarket.servicios;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.dao.exceptions.NonexistentEntityException;
import com.nibble.supermarket.modelo.Turno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurnoServicio implements IServicio<Turno, Integer>{

    @Override
    public void guardar(Turno entidad) {
        DaoManager.getInstance().getTurnoDao().create(entidad);
    }

    @Override
    public void actualizar(Turno entidad) {
        try {
            DaoManager.getInstance().getTurnoDao().edit(entidad);
        } catch (Exception ex) {
            Logger.getLogger(TurnoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            DaoManager.getInstance().getTurnoDao().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(TurnoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Turno buscarPorId(Integer id) {
        return DaoManager.getInstance().getTurnoDao().findTurno(id);
    }

    @Override
    public List<Turno> buscarTodos() {
        return DaoManager.getInstance().getTurnoDao().findTurnoEntities();
    }
    
}
