
package com.tiendaVirtual.tiendaVirtual.Servicios.Implement;

import com.tiendaVirtual.tiendaVirtual.Dao.CanastaPedidoDao;
import com.tiendaVirtual.tiendaVirtual.Modelo.CanastaPedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.tiendaVirtual.tiendaVirtual.Servicios.CanastaPedidoServicio;
import org.springframework.stereotype.Service;

/**
 *
 * @author danielgarcia
 */

@Service
public class CanastaPedidoImpl implements CanastaPedidoServicio {
    @Autowired
    private CanastaPedidoDao canastaPedidoDao;

    @Override
    @Transactional(readOnly=false)
    public CanastaPedido save(CanastaPedido canastaPedido) {
        return canastaPedidoDao.save(canastaPedido);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        canastaPedidoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public CanastaPedido findById(Integer id) {
        return canastaPedidoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<CanastaPedido> findAll() {
        return (List<CanastaPedido>) canastaPedidoDao.findAll();
    }
}
