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

    /**
     * Calcula el subtotal de la línea de acuerdo a la cantidad y el producto.
     * Si la cantidad es mayor o igual a 3 y el producto tiene una promoción "3x2",
     * se aplica la promoción. En caso contrario, se calcula el subtotal sin promoción.
     * @return El subtotal de la línea.
     */
    public double calcularSubTotal() {           
        // Verificar si la cantidad es mayor o igual a 3
        if (cantidad >= 3) {
            // Buscar la promoción "3x2" en las promociones del producto
            for (Promocion p : producto.getPromociones()) {
                if (p.getNombre().equals("3x2")) {
                    // Calcular la cantidad de productos con promoción y sin promoción
                    int cantidadPromocion = cantidad / 3;
                    int cantidadNormal = cantidad % 3;
                    // Calcular el subtotal aplicando la promoción
                    subtotal = cantidadPromocion * 2 * producto.getPrecio() + cantidadNormal * producto.getPrecio();
                    return subtotal;
                }
            }
        }
        
        // Calcular el subtotal sin promoción
        subtotal = cantidad * producto.getPrecio();
        return subtotal;
    }
}
