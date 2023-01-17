
package com.tiendaVirtual.tiendaVirtual.Dao;

import com.tiendaVirtual.tiendaVirtual.Modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author danielgarcia
 */
public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
    
}
