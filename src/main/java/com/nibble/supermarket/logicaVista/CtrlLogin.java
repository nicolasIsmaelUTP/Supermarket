package com.nibble.supermarket.logicaVista;

import com.nibble.supermarket.modelo.Empleado;
import com.nibble.supermarket.modelo.Turno;
import com.nibble.supermarket.servicios.EmpleadoServicio;
import com.nibble.supermarket.vista.Login;
import com.nibble.supermarket.vista.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlLogin implements ActionListener{

    Empleado empleado = new Empleado();
    EmpleadoServicio empleadoServicio = new EmpleadoServicio();
    Login view = new Login();
    
    public CtrlLogin(Login view){
        this.view = view;
        
        view.btnIniciarSesion.addActionListener(this);
    }
    
    public void iniciar(){
        view.setTitle("Iniciar Sesión");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    public void validacionLogin(){
        String pass = new String(view.txtPassword.getPassword());
        if(!view.txtUsername.getText().equals("") && !pass.equals("")){
            empleado.setDni(view.txtUsername.getText());
            empleado.setPassword(pass);
            
            Turno login = empleadoServicio.autenticar(empleado.getDni(), empleado.getPassword());
            
            if(login==null){
                JOptionPane.showMessageDialog(null, "Ingreso datos incorrectos");
            } else {
                Main v = new Main();
                view.dispose();
                //Falta implementar
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacíos");
        }
        
        
                // Cerramos esta ventana porque entraremos al formulario de Home
                view.dispose();

                // Entramos al formulario de Home
                FrmHome vistaHome = new FrmHome();
                CtrlHome frmHome = new CtrlHome(vistaHome);
                frmHome.setUsuario(usuario);
                
                vistaHome.setExtendedState(JFrame.MAXIMIZED_BOTH);
                vistaHome.setVisible(true);
                                    
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos o usuario inactivo");
            }
            
        } else {
            JOptionPane.showMessageDialog(view, "Los campos están vacíos, ingrese sus datos");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
