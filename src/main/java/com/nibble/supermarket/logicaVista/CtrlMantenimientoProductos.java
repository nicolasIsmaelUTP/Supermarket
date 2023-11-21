package com.nibble.supermarket.logicaVista;

import com.nibble.supermarket.modelo.Producto;
import com.nibble.supermarket.servicios.ProductoServicio;
import com.nibble.supermarket.vista.MantenimientoProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CtrlMantenimientoProductos implements ActionListener {

    Producto producto = new Producto();
    ProductoServicio productoServicio = new ProductoServicio();
    MantenimientoProductos view = new MantenimientoProductos();
    DefaultTableModel modeloTabla = new DefaultTableModel();

    public CtrlMantenimientoProductos(MantenimientoProductos view) {
        this.view = view;
        //Botones
        this.view.btnNuevo.addActionListener(this);
        this.view.btnGuardar.addActionListener(this);
        this.view.btnEditar.addActionListener(this);
        this.view.btnActualizar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);
        this.view.btnCancelar.addActionListener(this);
        this.view.btnBuscarProducto.addActionListener(this);

        this.view.btnGuardar.setEnabled(false);
        this.view.btnActualizar.setEnabled(false);
        this.view.btnCancelar.setEnabled(false);
        this.view.txtId.setEnabled(false);

        listar(view.jtResumen);
    }

    public void iniciar() {
        this.view.setTitle("Mantenimiento de productos");
        this.view.setVisible(true);
    }

    public void listar(JTable tabla) {
        this.modeloTabla = (DefaultTableModel) tabla.getModel();
        List<Producto> lista = productoServicio.buscarTodos();
        Object[] objeto = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getDescripcion();
            objeto[3] = lista.get(i).getPrecio();
            objeto[4] = lista.get(i).getStock();
            modeloTabla.addRow(objeto);
        }
        view.jtResumen.setModel(modeloTabla);
    }

    public void guardar() {
        if (view.txtNombre.getText().equals("") || view.txtDescripcion.getText().equals("") 
            || view.txtPrecio.getText().equals("") || view.txtStock.getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Hay campos vacios, debe llenar los campos");
        } else {
            String nombre = view.txtNombre.getText();
            String descripcion = view.txtDescripcion.getText();
            Double precio = Double.parseDouble(view.txtPrecio.getText());
            int stock = Integer.parseInt(view.txtStock.getText());

            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setStock(stock);

            productoServicio.guardar(producto);
            JOptionPane.showMessageDialog(view, "Producto guardado correctamente");
            limpiarCasilleros();
            limpiarTabla();
            listar(view.jtResumen);
            view.jtpMantenimientoProductos.setSelectedIndex(0);
            view.btnGuardar.setEnabled(false);
            view.btnNuevo.setEnabled(true);
            view.btnEditar.setEnabled(true);
            view.btnEliminar.setEnabled(true);
            view.btnActualizar.setEnabled(false);
            view.btnCancelar.setEnabled(false);
            view.txtBuscarProducto.setEnabled(true);
            view.btnBuscarProducto.setEnabled(true);
        }
    }

    public void llenarCasilleros() {
        int fila = view.jtResumen.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Debe seleccionar una fila");
            view.jtpMantenimientoProductos.setSelectedIndex(0);
        } else {
            int id = Integer.parseInt((String) view.jtResumen.getValueAt(fila, 0).toString());
            String nombre = (String) view.jtResumen.getValueAt(fila, 1);
            String descripcion = (String) view.jtResumen.getValueAt(fila, 2);
            Double precio = Double.parseDouble((String) view.jtResumen.getValueAt(fila, 3).toString());
            int stock = Integer.parseInt((String) view.jtResumen.getValueAt(fila, 4).toString());

            view.txtId.setText("" + id);
            view.txtNombre.setText(nombre);
            view.txtDescripcion.setText(descripcion);
            view.txtPrecio.setText("" + precio);
            view.txtStock.setText("" + stock);

            view.jtpMantenimientoProductos.setSelectedIndex(1);
            view.btnGuardar.setEnabled(false);
            view.btnNuevo.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
            view.btnActualizar.setEnabled(true);
            view.btnCancelar.setEnabled(true);
            view.txtBuscarProducto.setEnabled(false);
            view.btnBuscarProducto.setEnabled(false);
        }
    }

    public void actualizar() {
        int id = Integer.parseInt(view.txtId.getText());
        String nombre = view.txtNombre.getText();
        String descripcion = view.txtDescripcion.getText();
        Double precio = Double.parseDouble(view.txtPrecio.getText());
        int stock = Integer.parseInt(view.txtStock.getText());

        producto.setId(id);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);

        productoServicio.actualizar(producto);

        JOptionPane.showMessageDialog(view, "Producto actualizado correctamente");
        limpiarCasilleros(); //limpiar casilleros textField
        limpiarTabla(); //Ambos son para que se limpie la tabla y se actualice
        listar(view.jtResumen);

        view.jtpMantenimientoProductos.setSelectedIndex(0);
        view.btnGuardar.setEnabled(false);
        view.btnNuevo.setEnabled(true);
        view.btnEditar.setEnabled(true);
        view.btnEliminar.setEnabled(true);
        view.btnActualizar.setEnabled(false);
        view.btnCancelar.setEnabled(false);
        view.txtBuscarProducto.setEnabled(true);
        view.btnBuscarProducto.setEnabled(true);
        view.txtBuscarProducto.setText("");
    }

    public void eliminar() {
        int fila = view.jtResumen.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Debe seleccionar un Producto");
            view.jtpMantenimientoProductos.setSelectedIndex(0);
        } else {
            int id = Integer.parseInt((String) view.jtResumen.getValueAt(fila, 0).toString());
            productoServicio.eliminar(id);
            JOptionPane.showMessageDialog(view, "Producto eliminado correctamente");
            limpiarCasilleros();
            limpiarTabla();
            listar(view.jtResumen);
            view.txtBuscarProducto.setEnabled(true);
            view.txtBuscarProducto.setEnabled(true);
            view.txtBuscarProducto.setText("");
        }
    }

    public void buscar(JTable tabla) {
        this.modeloTabla = (DefaultTableModel) tabla.getModel();

        if (view.txtBuscarProducto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "El campo está vacío, ingrese un ID por favor.");
        } else {
            try {
                int id = Integer.parseInt(view.txtBuscarProducto.getText());
                producto = productoServicio.buscarPorId(id);

                if (producto == null) {
                    JOptionPane.showMessageDialog(view, "No se encontró ningún producto con ese ID.");
                } else {
                    limpiarTabla();
                    Object[] objeto = new Object[5];
                    objeto[0] = producto.getId();
                    objeto[1] = producto.getNombre();
                    objeto[2] = producto.getDescripcion();
                    objeto[3] = producto.getPrecio();
                    objeto[4] = producto.getStock();
                    modeloTabla.addRow(objeto);

                    view.jtResumen.setModel(modeloTabla);
                    view.btnCancelar.setEnabled(true);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "Ingrese un valor numérico válido para el ID.");
                // También podrías imprimir la traza de la pila para depuración: e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnNuevo) {
            limpiarCasilleros();
            view.jtpMantenimientoProductos.setSelectedIndex(1);

            view.btnGuardar.setEnabled(true);
            view.btnNuevo.setEnabled(false);
            view.btnEditar.setEnabled(false);
            view.btnEliminar.setEnabled(false);
            view.btnActualizar.setEnabled(false);
            view.txtBuscarProducto.setEnabled(false);
            view.btnBuscarProducto.setEnabled(false);
            view.btnCancelar.setEnabled(true);
            view.txtBuscarProducto.setText("");
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
            view.txtBuscarProducto.setText("");
            view.jtpMantenimientoProductos.setSelectedIndex(0);
            view.btnCancelar.setEnabled(false);
            view.btnGuardar.setEnabled(false);
            view.btnNuevo.setEnabled(true);
            view.btnEditar.setEnabled(true);
            view.btnEliminar.setEnabled(true);
            view.btnActualizar.setEnabled(false);
            view.txtBuscarProducto.setEnabled(true);
            view.btnBuscarProducto.setEnabled(true);
        }
        if (e.getSource() == view.btnBuscarProducto) {
            buscar(view.jtResumen);
        }
    }

    public void limpiarCasilleros() {
        view.txtId.setText("");
        view.txtNombre.setText("");
        view.txtDescripcion.setText("");
        view.txtPrecio.setText("");
        view.txtStock.setText("");
    }

    public void limpiarTabla() {
        for (int i = 0; i < view.jtResumen.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }

}
