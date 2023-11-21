package com.nibble.supermarket.servicios;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.dao.exceptions.NonexistentEntityException;
import com.nibble.supermarket.modelo.Linea;
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
    

    /**
     * Cierra un ticket y lo guarda en el sistema.
     * 
     * @param ticket El ticket a cerrar.
     */
    public void cerrarTicket(Ticket ticket) {
        guardar(ticket);
    }

    public String mostrarTicket(Ticket ticket) {
        String texto = "";
        // Cabecera
        texto += "Fecha: " + ticket.getFecha() + "\n";
        texto += "Nro. de ticket: " + ticket.getId() + "\n";
        texto += "Cliente: " + ticket.getCliente().getPrimerApellido()+ " ";
        texto += ticket.getCliente().getSegundoApellido()+ " ";
        texto += ticket.getCliente().getPrimerNombre()+ " ";
        texto += ticket.getCliente().getSegundoNombre()+ "\n";
        texto += "----------------------------------------\n";
        // Cuerpo
        for (Linea linea : ticket.getLineas()) {
            texto += linea.getProducto().getNombre() + " x " + linea.getCantidad() + " = " + linea.getSubtotal() + "\n";
        }
        texto += "----------------------------------------\n";
        // Pie
        texto += "Total: " + ticket.getTotal() + "\n";
        texto += "Gracias por su compra!";
        return texto;
    }
}
