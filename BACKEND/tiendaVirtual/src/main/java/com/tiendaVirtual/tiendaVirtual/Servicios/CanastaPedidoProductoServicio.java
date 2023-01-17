
package com.tiendaVirtual.tiendaVirtual.Servicios;

import com.tiendaVirtual.tiendaVirtual.Modelo.CanastaPedidoProducto;
import java.util.List;

/**
 *
 * @author danielgarcia
 */
public interface CanastaPedidoProductoServicio {
    public CanastaPedidoProducto save(CanastaPedidoProducto canastaPedidoProducto); 
    public void delete(Integer id);
    public CanastaPedidoProducto findById(Integer id); 
    public List<CanastaPedidoProducto> findAll();
}
