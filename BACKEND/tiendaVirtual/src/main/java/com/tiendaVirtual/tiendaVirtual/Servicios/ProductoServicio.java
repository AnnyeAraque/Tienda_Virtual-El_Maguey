
package com.tiendaVirtual.tiendaVirtual.Servicios;

import com.tiendaVirtual.tiendaVirtual.Modelo.Producto;
import java.util.List;

/**
 *
 * @author danielgarcia
 */
public interface ProductoServicio {
    public Producto save(Producto producto); 
    public void delete(Integer id);
    public Producto findById(Integer id); 
    public List<Producto> findAll();
}
