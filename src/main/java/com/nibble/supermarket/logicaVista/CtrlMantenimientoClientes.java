package com.nibble.supermarket.logicaVista;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.vista.MantenimientoClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class CtrlMantenimientoClientes implements ActionListener {
    
    //CLASE MODELO
    
    MantenimientoClientes view = new MantenimientoClientes();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    
    
    public CtrlMantenimientoClientes (MantenimientoClientes view){
        this.view = view;
        //Botones
        this.view.btnNuevo.addActionListener(this);
        this.view.btnGuardar.addActionListener(this);
        this.view.btnEditar.addActionListener(this);
        this.view.btnActualizar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
        
        this.view.btnGuardar.setEnabled(false);
        this.view.btnActualizar.setEnabled(false);
        this.view.btnCancelar.setEnabled(false);
    }
    
    public void iniciar(){
        this.view.setTitle("Mantenimiento de clientes");
        this.view.setVisible(true);
    }
    
    public void listar(){
        
    }
    
    public void guardar(){
        
    }
    
    public void llenarCasilleros(){
        
    }
    
    public void actualizar(){
        
    }
    
    public void eliminar(){
        
    }
    
    public void buscar(){
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.btnNuevo){
            
        }
        if(e.getSource() == view.btnGuardar){
            
        }
        if(e.getSource() == view.btnEditar){
            
        }
        if(e.getSource() == view.btnActualizar){
            
        }
        if(e.getSource() == view.btnEliminar){
            
        }
        if(e.getSource() == view.btnCancelar){
            
        }
        if(e.getSource() == view.btnBuscarCliente){
            
        }
    }
 
    
    public void limpiarCasilleros(){
        view.txtDni.setText("");
        view.txtPrimerNombre.setText("");
        view.txtSegundoNombre.setText("");
        view.txtApellidoPaterno.setText("");
        view.txtApellidoMaterno.setText("");
        view.txtEdad.setText("");
    }
    
    public void limpiarTabla(){
        for (int i = 0; i < view.jtResumen.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i=i-1;
        } 
    }
}
