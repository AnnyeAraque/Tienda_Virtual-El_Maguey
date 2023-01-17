
package com.tiendaVirtual.tiendaVirtual.Servicios;

import com.tiendaVirtual.tiendaVirtual.Modelo.CanastaPedido;
import java.util.List;

/**
 *
 * @author danielgarcia
 */
public interface CanastaPedidoServicio {
    public CanastaPedido save(CanastaPedido canastaPedido); 
    public void delete(Integer id);
    public CanastaPedido findById(Integer id); 
    public List<CanastaPedido> findAll();
}
