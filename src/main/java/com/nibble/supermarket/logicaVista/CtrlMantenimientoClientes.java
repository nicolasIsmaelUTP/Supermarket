package com.nibble.supermarket.logicaVista;

import com.nibble.supermarket.modelo.Cliente;
import com.nibble.supermarket.servicios.ClienteServicio;
import com.nibble.supermarket.vista.MantenimientoClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CtrlMantenimientoClientes implements ActionListener {

    Cliente cliente = new Cliente();
    ClienteServicio clienteServicio = new ClienteServicio();
    MantenimientoClientes view = new MantenimientoClientes();
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public CtrlMantenimientoClientes(MantenimientoClientes view) {
        this.view = view;
        //Botones
        this.view.btnNuevo.addActionListener(this);
        this.view.btnGuardar.addActionListener(this);
        this.view.btnEditar.addActionListener(this);
        this.view.btnActualizar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
        this.view.btnBuscarCliente.addActionListener(this);

        this.view.btnGuardar.setEnabled(false);
        this.view.btnActualizar.setEnabled(false);
        this.view.btnCancelar.setEnabled(false);

        listar(view.jtResumen);
    }

    public void iniciar() {
        this.view.setTitle("Mantenimiento de clientes");
        this.view.setVisible(true);
    }

    public void listar(JTable tabla) {
        this.modeloTabla = (DefaultTableModel) tabla.getModel();
        List<Cliente> lista = clienteServicio.buscarTodos();
        Object[] objeto = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getDni();
            objeto[1] = lista.get(i).getPrimerNombre();
            objeto[2] = lista.get(i).getSegundoNombre();
            objeto[3] = lista.get(i).getPrimerApellido();
            objeto[4] = lista.get(i).getSegundoApellido();
            objeto[5] = lista.get(i).getEdad();
            modeloTabla.addRow(objeto);
        }
        view.jtResumen.setModel(modeloTabla);
    }

    public void guardar() {
        if (view.txtDni.getText().equals("") || view.txtPrimerNombre.getText().equals("")
                || view.txtSegundoNombre.getText().equals("") || view.txtApellidoPaterno.getText().equals("")
                || view.txtApellidoMaterno.getText().equals("") || view.txtEdad.getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Hay campos vacios, debe llenar los campos");
        } else {
            String dni = view.txtDni.getText();
            String primerNombre = view.txtPrimerNombre.getText();
            String segundoNombre = view.txtSegundoNombre.getText();
            String apellidoPaterno = view.txtApellidoPaterno.getText();
            String apellidoMaterno = view.txtApellidoPaterno.getText();
            int edad = Integer.parseInt(view.txtEdad.getText());

            cliente.setDni(dni);
            cliente.setPrimerNombre(primerNombre);
            cliente.setSegundoNombre(segundoNombre);
            cliente.setPrimerApellido(apellidoPaterno);
            cliente.setSegundoApellido(apellidoMaterno);
            cliente.setEdad(edad);

            clienteServicio.guardar(cliente);
            JOptionPane.showMessageDialog(view, "Cliente guardado correctamente");
            limpiarCasilleros();
            limpiarTabla();
            listar(view.jtResumen);
            view.jtpMantenimientoClientes.setSelectedIndex(0);
            view.btnGuardar.setEnabled(false);
            view.btnNuevo.setEnabled(true);
            view.btnEditar.setEnabled(true);
            view.btnEliminar.setEnabled(true);
            view.btnActualizar.setEnabled(false);
            view.btnCancelar.setEnabled(false);
            view.txtBuscarCliente.setEnabled(true);
            view.btnBuscarCliente.setEnabled(true);

        }
    }

    public void llenarCasilleros() {
        int fila = view.jtResumen.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Debe seleccionar una fila");
            view.jtpMantenimientoClientes.setSelectedIndex(0);
        } else {
            String dni = (String) view.jtResumen.getValueAt(fila, 0);
            String primerNombre = (String) view.jtResumen.getValueAt(fila, 1);
            String segundoNombre = (String) view.jtResumen.getValueAt(fila, 2);
            String apellidoPaterno = (String) view.jtResumen.getValueAt(fila, 3);
            String apellidoMaterno = (String) view.jtResumen.getValueAt(fila, 4);
            int edad = Integer.parseInt((String) view.jtResumen.getValueAt(fila, 5).toString());

            view.txtDni.setText(dni);
            view.txtPrimerNombre.setText(primerNombre);
            view.txtSegundoNombre.setText(segundoNombre);
            view.txtApellidoPaterno.setText(apellidoPaterno);
            view.txtApellidoMaterno.setText(apellidoMaterno);
            view.txtEdad.setText("" + edad);

            view.jtpMantenimientoClientes.setSelectedIndex(1);
            view.btnGuardar.setEnabled(false);
            view.btnNuevo.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
            view.btnActualizar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            view.txtBuscarCliente.setEnabled(false);
            view.btnBuscarCliente.setEnabled(false);
        }
    }

    public void actualizar() {
        String dni = view.txtDni.getText();
        String primerNombre = view.txtPrimerNombre.getText();
        String segundoNombre = view.txtSegundoNombre.getText();
        String apellidoPaterno = view.txtApellidoPaterno.getText();
        String apellidoMaterno = view.txtApellidoPaterno.getText();
        int edad = Integer.parseInt(view.txtEdad.getText());

        cliente.setDni(dni);
        cliente.setPrimerNombre(primerNombre);
        cliente.setSegundoNombre(segundoNombre);
        cliente.setPrimerApellido(apellidoPaterno);
        cliente.setSegundoApellido(apellidoMaterno);
        cliente.setEdad(edad);

        clienteServicio.actualizar(cliente);

        JOptionPane.showMessageDialog(view, "Cliente actualizado correctamente");
        limpiarCasilleros(); //limpiar casilleros textField
        limpiarTabla(); //Ambos son para que se limpie la tabla y se actualice
        listar(view.jtResumen);

        view.jtpMantenimientoClientes.setSelectedIndex(0);
        view.btnGuardar.setEnabled(false);
        view.btnNuevo.setEnabled(true);
        view.btnEditar.setEnabled(true);
        view.btnEliminar.setEnabled(true);
        view.btnActualizar.setEnabled(false);
        view.btnCancelar.setEnabled(false);
        view.txtBuscarCliente.setEnabled(true);
        view.btnBuscarCliente.setEnabled(true);
        view.txtBuscarCliente.setText("");
    }

    public void eliminar() {
        int fila = view.jtResumen.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Debe seleccionar un Cliente");
            view.jtpMantenimientoClientes.setSelectedIndex(0);
        } else {
            String dni = (String) view.jtResumen.getValueAt(fila, 0);
            clienteServicio.eliminar(dni);
            JOptionPane.showMessageDialog(view, "Cliente eliminado correctamente");
            limpiarCasilleros();
            limpiarTabla();
            listar(view.jtResumen);
            view.txtBuscarCliente.setEnabled(true);
            view.txtBuscarCliente.setEnabled(true);
            view.txtBuscarCliente.setText("");
        }
    }

    public void buscar(JTable tabla) {
        this.modeloTabla = (DefaultTableModel) tabla.getModel();
        String dni = view.txtBuscarCliente.getText();

        boolean esNumero = true;
        for (char caracter : dni.toCharArray()) {
            if (!Character.isDigit(caracter)) {
                esNumero = false;
                break;
            }
        }

        if (!esNumero) {
            JOptionPane.showMessageDialog(view, "Error, el DNI debe contener solo numeros.");
            view.btnCancelar.setEnabled(true);
            return;
        }

        if(view.txtBuscarCliente.getText().equals("")){
            JOptionPane.showMessageDialog(view, "El campo esta vacio, ingrese el DNI por favor.");
        } else {
            cliente = clienteServicio.buscarPorId(dni);
            if (cliente == null || cliente.getDni().equals("")) {
                JOptionPane.showMessageDialog(view, "No se encontro ningun Cliente con ese DNI.");
            } else {
                limpiarTabla();
                Object[] objeto = new Object[6];
                objeto[0] = cliente.getDni();
                objeto[1] = cliente.getPrimerNombre();
                objeto[2] = cliente.getSegundoNombre();
                objeto[3] = cliente.getPrimerApellido();
                objeto[4] = cliente.getSegundoApellido();
                objeto[5] = cliente.getEdad();
                modeloTabla.addRow(objeto);

                view.jtResumen.setModel(modeloTabla);
                view.btnCancelar.setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnNuevo) {
            limpiarCasilleros();
            view.jtpMantenimientoClientes.setSelectedIndex(1);

            view.btnGuardar.setEnabled(true);
            view.btnNuevo.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
            view.btnActualizar.setEnabled(false);
            view.txtBuscarCliente.setEnabled(false);
            view.btnBuscarCliente.setEnabled(false);
            view.btnCancelar.setEnabled(true);
            view.txtBuscarCliente.setText("");
        }
        if (e.getSource() == view.btnGuardar) {
            guardar();
        }
        if (e.getSource() == view.btnEditar) {
            llenarCasilleros();
        }
        if (e.getSource() == view.btnActualizar) {
            actualizar();
        }
        if (e.getSource() == view.btnEliminar) {
            eliminar();
        }
        if (e.getSource() == view.btnCancelar) {
            limpiarTabla();
            limpiarCasilleros();
            listar(view.jtResumen);
            view.txtBuscarCliente.setText("");
            view.jtpMantenimientoClientes.setSelectedIndex(0);
            view.btnCancelar.setEnabled(false);
            view.btnGuardar.setEnabled(false);
            view.btnNuevo.setEnabled(true);
            view.btnEditar.setEnabled(true);
            view.btnEliminar.setEnabled(true);
            view.btnActualizar.setEnabled(false);
            view.txtBuscarCliente.setEnabled(true);
            view.btnBuscarCliente.setEnabled(true);
        }
        if (e.getSource() == view.btnBuscarCliente) {
            buscar(view.jtResumen);
        }
    }

    public void limpiarCasilleros() {
        view.txtDni.setText("");
        view.txtPrimerNombre.setText("");
        view.txtSegundoNombre.setText("");
        view.txtApellidoPaterno.setText("");
        view.txtApellidoMaterno.setText("");
        view.txtEdad.setText("");
    }

    public void limpiarTabla() {
        for (int i = 0; i < view.jtResumen.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }
}
