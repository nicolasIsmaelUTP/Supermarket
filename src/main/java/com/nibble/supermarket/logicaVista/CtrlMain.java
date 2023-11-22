package com.nibble.supermarket.logicaVista;

import com.nibble.supermarket.modelo.Empleado;
import com.nibble.supermarket.modelo.Turno;
import com.nibble.supermarket.vista.Main;

public class CtrlMain {
    Turno turno;
    Main view = new Main();
    
    public CtrlMain(Main view) {
        this.view = view;
        this.view.setVisible(true);
    }
    
    public void setTurno(Turno t){
        this.turno = t; 
        view.txtUsuario.setText(t.getEmpleado().getPrimerNombre());
    }
}
