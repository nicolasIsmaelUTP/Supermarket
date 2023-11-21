package com.nibble.supermarket.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TipoTurno tipoTurno;
    @ManyToOne
    private Empleado empleado;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "turno")
    private List<Ticket> tickets = new ArrayList<>();

    public Turno() {
    }

    public Turno(TipoTurno tipoTurno, Empleado empleado, List<Ticket> tickets) {
        this.tipoTurno = tipoTurno;
        this.empleado = empleado;
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoTurno getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(TipoTurno tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    // Métodos de conveniencia para agregar y remover tickets
    
    public Ticket addTicket(Ticket ticket) {
        ticket.setTurno(this);
        tickets.add(ticket);
        return ticket;
    }

    public Ticket removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        return ticket;
    }
}
