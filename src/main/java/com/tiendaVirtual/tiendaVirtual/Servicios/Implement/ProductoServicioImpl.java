
package com.tiendaVirtual.tiendaVirtual.Servicios.Implement;


import com.tiendaVirtual.tiendaVirtual.Dao.ProductoDao;
import com.tiendaVirtual.tiendaVirtual.Modelo.Producto;
import com.tiendaVirtual.tiendaVirtual.Servicios.ProductoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danielgarcia
 */

@Service
public class ProductoServicioImpl implements ProductoServicio{
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly=false)
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        productoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Producto findById(Integer id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }
    
}
