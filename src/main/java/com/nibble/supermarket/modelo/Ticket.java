package com.nibble.supermarket.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private Date fecha;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Turno turno;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
    private List<Linea> lineas;

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

    // Métodos de conveniencia para agregar y remover lineas
    public Linea addLinea(Linea linea) {
        getLineas().add(linea);
        return linea;
    }

    public Linea removeLinea(Linea linea) {
        getLineas().remove(linea);
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
        addLinea(linea);
    }

    public void registrarVenta(Producto producto, int cantidad) {
        Linea linea = new Linea();
        linea.setCantidad(cantidad);
        linea.setProducto(producto);
        linea.setTipoLinea(TipoLinea.REPETICION);
        addLinea(linea);
    }

    public void anularVenta(Linea linea){
        Linea lineaAnulacion = new Linea();
        lineaAnulacion.setCantidad(-linea.getCantidad());
        lineaAnulacion.setProducto(linea.getProducto());
        lineaAnulacion.setTipoLinea(TipoLinea.ANULACION);
        addLinea(lineaAnulacion);
    }

    public void registrarDevolucion(Producto producto) {
        Linea linea = new Linea();
        linea.setCantidad(1);
        linea.setProducto(producto);
        linea.setTipoLinea(TipoLinea.DEVOLUCION);
        addLinea(linea);
    }

    public void registrarDevolucion(Producto producto, int cantidad) {
        Linea linea = new Linea();
        linea.setCantidad(cantidad);
        linea.setProducto(producto);
        linea.setTipoLinea(TipoLinea.DEVOLUCION);
        addLinea(linea);
    }
}
