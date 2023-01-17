
package com.tiendaVirtual.tiendaVirtual.Servicios.Implement;

import com.tiendaVirtual.tiendaVirtual.Dao.CanastaPedidoProductoDao;
import com.tiendaVirtual.tiendaVirtual.Modelo.CanastaPedidoProducto;
import com.tiendaVirtual.tiendaVirtual.Servicios.CanastaPedidoProductoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danielgarcia
 */

@Service
public class CanastaPedidoProductoImpl implements CanastaPedidoProductoServicio {
    @Autowired
    private CanastaPedidoProductoDao canastaPedidoProductoDao;

    @Override
    @Transactional(readOnly=false)
    public CanastaPedidoProducto save(CanastaPedidoProducto canastaPedidoProducto) {
        return canastaPedidoProductoDao.save(canastaPedidoProducto);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        canastaPedidoProductoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public CanastaPedidoProducto findById(Integer id) {
        return canastaPedidoProductoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<CanastaPedidoProducto> findAll() {
        return (List<CanastaPedidoProducto>) canastaPedidoProductoDao.findAll();
    }
}
