package com.nibble.supermarket.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Linea implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    @ManyToOne
    private Producto producto;
    private TipoLinea tipoLinea;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Ticket ticket;
    private double subtotal;

    public Linea() {
    }

    public Linea(int cantidad, Producto producto, TipoLinea tipoLinea) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.tipoLinea = tipoLinea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoLinea getTipoLinea() {
        return tipoLinea;
    }

    public void setTipoLinea(TipoLinea tipoLinea) {
        this.tipoLinea = tipoLinea;
    }

    public double getSubtotal() {
        subtotal = producto.getPrecio() * cantidad - tresPorDos() - descuentoAdultoMayor();
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket t) {
        this.ticket = t;
    }

    /**
     * Calcula el descuento aplicable a la cantidad de productos en base a la promoción "3x2".
     * Si la cantidad es mayor o igual a 3 y existe la promoción "3x2" para el producto, se calcula
     * la cantidad de productos con promoción y sin promoción, y se determina el descuento a aplicar.
     * 
     * @return el descuento a aplicar si se cumple la promoción "3x2", de lo contrario retorna 0.
     */
    public double tresPorDos() {
        // Verificar si la cantidad es mayor o igual a 3
        if (cantidad >= 3) {
            // Buscar la promoción "3x2" en las promociones del producto
            for (Promocion p : producto.getPromociones()) {
                if (p.getNombre().equals("3x2")) {
                    // Calcular la cantidad de productos con promoción y sin promoción
                    int cantidadPromocion = cantidad / 3;
                    // Calcular el descuento que se va a restar
                    double descuento = cantidadPromocion * producto.getPrecio();
                    return descuento;
                }
            }
        }

        return 0;
    }

    /**
     * Calcula el descuento aplicable para clientes adultos mayores.
     * Si el cliente tiene 60 años o más, se verifica si el producto tiene una promoción
     * específica para adultos mayores. En caso afirmativo, se aplica un descuento del 15%
     * sobre el precio del producto.
     * @return el monto del descuento aplicado, o 0 si no aplica descuento.
     */
    public double descuentoAdultoMayor() {
        // Verificar si el cliente es adulto mayor (mayor o igual a 60 años)
        if (ticket.getCliente().getEdad() >= 60) {
            // Buscar la promoción "adultomayor" en las promociones del producto
            for (Promocion p : producto.getPromociones()) {
                if (p.getNombre().equals("adultomayor")) {
                    // Calcular el descuento aplicando el 15% del precio del producto
                    double descuento = producto.getPrecio() * cantidad * 0.15;
                    return descuento;
                }
            }
        }

        return 0;
    }

}
