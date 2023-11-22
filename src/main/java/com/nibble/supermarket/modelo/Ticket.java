package com.nibble.supermarket.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha = new Date();
    @ManyToOne
    private Cliente cliente = new Cliente();
    @ManyToOne
    private Turno turno;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
    private List<Linea> lineas = new ArrayList<>();
    private double total;

    public Ticket() {
    }

    public Ticket(Date fecha, Cliente cliente, List<Linea> lineas) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.lineas = lineas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    public double getTotal() {
        total = 0;
        for (Linea linea : lineas) {
            total += linea.getSubtotal();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    // Métodos de conveniencia para agregar y remover lineas
    public Linea addLinea(Linea linea) {
        lineas.add(linea);
        return linea;
    }

    public Linea removeLinea(Linea linea) {
        lineas.remove(linea);
        return linea;
    }
    
    

    // public Linea registrarVenta(Linea linea){
    //     linea.setTipoLinea(TipoLinea.VENTA);
    //     addLinea(linea);
    //     return linea;
    // }
    // public Linea registrarVentaRepetida(Linea linea, int cantidad){
    //     linea.setTipoLinea(TipoLinea.REPETICION);
    //     linea.setCantidad(cantidad);
    //     addLinea(linea);
    //     return linea;
    // }

    public void registrarVenta(Producto producto) {
        Linea linea = new Linea();
        linea.setCantidad(1);
        linea.setProducto(producto);
        linea.setTipoLinea(TipoLinea.VENTA);
        linea.setTicket(this);
        linea.getSubtotal();
        addLinea(linea);

        // Restar stock de producto
        linea.getProducto().setStock(linea.getProducto().getStock() - 1);
    }

    public void registrarVenta(Producto producto, int cantidad) {
        Linea linea = new Linea();
        linea.setCantidad(cantidad);
        linea.setProducto(producto);
        linea.setTipoLinea(TipoLinea.REPETICION);
        linea.setTicket(this);
        linea.getSubtotal();
        addLinea(linea);

        // Restar stock de producto
        linea.getProducto().setStock(linea.getProducto().getStock() - cantidad);
    }

    public void anularVenta(Linea linea){
        Linea lineaAnulacion = new Linea();
        lineaAnulacion.setCantidad(-linea.getCantidad());
        lineaAnulacion.setProducto(linea.getProducto());
        lineaAnulacion.setTipoLinea(TipoLinea.ANULACION);
        lineaAnulacion.setTicket(this);
        linea.getSubtotal();
        addLinea(lineaAnulacion);

        // Sumar stock de producto
        linea.getProducto().setStock(linea.getProducto().getStock() + linea.getCantidad());
    }

    public void registrarDevolucion(Producto producto) {
        Linea linea = new Linea();
        linea.setCantidad(1);
        linea.setProducto(producto);
        linea.setTipoLinea(TipoLinea.DEVOLUCION);
        linea.getSubtotal();
        addLinea(linea);

        // Sumar stock de producto
        linea.getProducto().setStock(linea.getProducto().getStock() + 1);
    }

    public void registrarDevolucion(Producto producto, int cantidad) {
        Linea linea = new Linea();
        linea.setCantidad(cantidad);
        linea.setProducto(producto);
        linea.setTipoLinea(TipoLinea.DEVOLUCION);
        addLinea(linea);

        // Sumar stock de producto
        linea.getProducto().setStock(linea.getProducto().getStock() + cantidad);
    }
}
