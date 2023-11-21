package com.nibble.supermarket.modelo;

import java.io.Serializable;
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
    @ManyToOne
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
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

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

    public void aplicarDescuentos() {
        // Calcular el subtotal
        subtotal = producto.getPrecio() * cantidad;
        // Aplicar descuentos
        subtotal -= tresPorDos();
        subtotal -= descuentoAdultoMayor();
    }
}
