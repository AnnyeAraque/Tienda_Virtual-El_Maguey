
package com.tiendaVirtual.tiendaVirtual.Dao;

import com.tiendaVirtual.tiendaVirtual.Modelo.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author danielgarcia
 */
public interface ProductoDao extends CrudRepository<Producto, Integer> {
    
}
