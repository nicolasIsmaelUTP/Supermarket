
package com.nibble.supermarket.servicios;

import java.util.List;

public interface IServicio<T, ID> {

    public void guardar(T entidad);

    public void actualizar(T entidad);

    public void eliminar(ID id);

    public T buscarPorId(ID id);

    public List<T> buscarTodos();
    
}
