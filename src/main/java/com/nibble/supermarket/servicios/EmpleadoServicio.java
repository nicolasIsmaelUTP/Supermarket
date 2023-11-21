
package com.nibble.supermarket.servicios;

import com.nibble.supermarket.dao.DaoManager;
import com.nibble.supermarket.dao.exceptions.NonexistentEntityException;
import com.nibble.supermarket.modelo.Empleado;
import com.nibble.supermarket.modelo.Turno;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmpleadoServicio implements IServicio<Empleado,String>{

    // Implementación de los métodos CRUD
    
    @Override
    public void guardar(Empleado entidad) {
        try {
            DaoManager.getInstance().getEmpleadoDao().create(entidad);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(Empleado entidad) {
        try {
            DaoManager.getInstance().getEmpleadoDao().edit(entidad);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(String id) {
        try {
            DaoManager.getInstance().getEmpleadoDao().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Empleado buscarPorId(String id) {
        return DaoManager.getInstance().getEmpleadoDao().findEmpleado(id);
    }

    @Override
    public List<Empleado> buscarTodos() {
        return DaoManager.getInstance().getEmpleadoDao().findEmpleadoEntities();
    }

    
    /**
        * Autentica a un empleado utilizando su DNI y contraseña.
        * Si el empleado es autenticado exitosamente, se abre un turno para él y se guarda en la base de datos.
        * 
        * @param dni el DNI del empleado
        * @param password la contraseña del empleado
        * @return el turno abierto para el empleado autenticado, o null si la autenticación falla
        */
    public Turno autenticar(String dni, String password) {
        Empleado empleado = buscarPorId(dni);
        if (empleado != null && empleado.getPassword().equals(password)) {
            Turno turno = empleado.abrirTurno();
            DaoManager.getInstance().getTurnoDao().create(turno);
            return turno;
        }
        return null;
    }
    
}
