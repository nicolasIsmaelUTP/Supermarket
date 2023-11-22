package com.nibble.supermarket.logicaVista;

import com.nibble.supermarket.modelo.Empleado;
import com.nibble.supermarket.modelo.Producto;
import com.nibble.supermarket.modelo.Ticket;
import com.nibble.supermarket.modelo.Turno;
import com.nibble.supermarket.servicios.ClienteServicio;
import com.nibble.supermarket.servicios.ProductoServicio;
import com.nibble.supermarket.servicios.TicketServicio;
import com.nibble.supermarket.vista.AgregarRepeticion;
import com.nibble.supermarket.vista.AgregarVentas;
import com.nibble.supermarket.vista.Main;
import com.nibble.supermarket.vista.VentanaEliminacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CtrlMain implements ActionListener {
    Turno turno;
    Main view = new Main();

    Producto producto = new Producto();
    ProductoServicio productoServicio = new ProductoServicio();
    TicketServicio ticketServicio = new TicketServicio();
    ClienteServicio clienteServicio = new ClienteServicio();

    List<Ticket> tickets = new ArrayList<>();
    Ticket ticketAbierto = new Ticket();

    AgregarVentas v1 = new AgregarVentas();
    AgregarRepeticion v2 = new AgregarRepeticion();
    VentanaEliminacion v3 = new VentanaEliminacion();

    public CtrlMain(Main view) {
        this.view = view;
        this.view.setVisible(true);

        view.BtnVentas.addActionListener(this);
        view.BtnRepeticion.addActionListener(this);
        view.BtnAnulacion.addActionListener(this);
        view.BtnImprimir.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("Main");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    public void setTurno(Turno t) {
        this.turno = t;
        view.txtUsuario.setText(t.getEmpleado().getPrimerNombre());
    }

    // METODO PARA RECUPERAR EL CODIGO
    public String recuperarCodigoVentas() {
        String code = v1.txtentrada.getText();
        return code;
    }

    public String recuperarCodigoRepeticion() {
        String code = v2.txtCodigo.getText();
        return code;
    }

    public String recuperarCodigoAnulacion() {
        String code = v3.txtentrada.getText();
        return code;
    }

    //

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.BtnVentas) {
            v1.setVisible(true);
            v1.setLocationRelativeTo(null);
            v1.setTitle("Ventas");
            v1.BtnAgregar.addActionListener(this);
        }
        if (e.getSource() == view.BtnRepeticion) {
            v2.setVisible(true);
            v2.setLocationRelativeTo(null);
            v2.setTitle("Repeticion");
            v2.BtnAgregar.addActionListener(this);
        }
        if (e.getSource() == view.BtnAnulacion) {
            v3.setVisible(true);
            v3.setLocationRelativeTo(null);
            v3.setTitle("Anulacion");
            v3.BtnAgregar.addActionListener(this);
        }
        if (e.getSource() == view.BtnImprimir) {
            ticketServicio.crearPDF(ticketAbierto);
            JOptionPane.showMessageDialog(null, "Impreso");
        }
        if (e.getSource() == v1.BtnAgregar) {
            String codigo = v1.txtentrada.getText();
            ticketAbierto.registrarVenta(productoServicio.buscarPorId(Integer.parseInt(codigo)));
            ticketAbierto.setCliente(clienteServicio.buscarPorId(view.tf_dnicliente.getText()));
            view.ta_info.setText(ticketServicio.mostrarTicket(ticketAbierto));
        }
        if (e.getSource() == v2.BtnAgregar) {
            String codigo = v2.txtCodigo.getText();
            String cantidad = v2.txtCantidad.getText();
            ticketAbierto.registrarVenta(productoServicio.buscarPorId(Integer.parseInt(codigo)), Integer.parseInt(cantidad));
            ticketAbierto.setCliente(clienteServicio.buscarPorId(view.tf_dnicliente.getText()));
            view.ta_info.setText(ticketServicio.mostrarTicket(ticketAbierto));
        }
        if (e.getSource() == v3.BtnAgregar) {
            
        }
    }
}
