package com.nibble.supermarket.logicaVista;

import com.nibble.supermarket.modelo.Empleado;
import com.nibble.supermarket.modelo.Producto;
import com.nibble.supermarket.modelo.Ticket;
import com.nibble.supermarket.modelo.Turno;
import com.nibble.supermarket.servicios.ProductoServicio;
import com.nibble.supermarket.vista.AgregarRepeticion;
import com.nibble.supermarket.vista.AgregarVentas;
import com.nibble.supermarket.vista.Main;
import com.nibble.supermarket.vista.VentanaEliminacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CtrlMain implements ActionListener{
    Turno turno;
    Main view = new Main();
    
    Producto producto = new Producto();
    ProductoServicio productoServicio = new ProductoServicio();
    List<Ticket> tickets = new ArrayList<>();
    
    AgregarVentas v1 = new AgregarVentas();
    AgregarRepeticion v2 = new AgregarRepeticion();
    VentanaEliminacion v3 = new VentanaEliminacion();
    
    public CtrlMain(Main view) {
        this.view = view;
        this.view.setVisible(true);
        
        view.BtnVentas.addActionListener(this);
        view.BtnRepeticion.addActionListener(this);
        view.BtnAnulacion.addActionListener(this);
    }
    
    public void iniciar() {
        view.setTitle("Main");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void setTurno(Turno t){
        this.turno = t; 
        view.txtUsuario.setText(t.getEmpleado().getPrimerNombre());
    }

    //METODO PARA RECUPERAR EL CODIGO
    public String recuperarCodigoVentas(){
        String code =  v1.txtentrada.getText();
        return code;
    }
    public String recuperarCodigoRepeticion(){
        String code =  v2.txtCodigo.getText();
        return code;
    }
    public String recuperarCodigoAnulacion(){
        String code =  v3.txtentrada.getText();
        return code;
    }
    
    //
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.BtnVentas) {
            
        }
        if (e.getSource() == view.BtnRepeticion) {
            
        }
        if (e.getSource() == view.BtnAnulacion) {
            
        }
    }
}
