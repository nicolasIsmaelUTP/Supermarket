package com.nibble.supermarket.servicios;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.dao.exceptions.NonexistentEntityException;
import com.nibble.supermarket.modelo.Ticket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketServicio implements IServicio<Ticket, Integer>{

    @Override
    public void guardar(Ticket entidad) {
        DaoManager.getInstance().getTicketDao().create(entidad);
    }

    @Override
    public void actualizar(Ticket entidad) {
        try {
            DaoManager.getInstance().getTicketDao().edit(entidad);
        } catch (Exception ex) {
            Logger.getLogger(TicketServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            DaoManager.getInstance().getTicketDao().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(TicketServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Ticket buscarPorId(Integer id) {
        return DaoManager.getInstance().getTicketDao().findTicket(id);
    }

    @Override
    public List<Ticket> buscarTodos() {
        return DaoManager.getInstance().getTicketDao().findTicketEntities();
    }
    
}
