
package com.tiendaVirtual.tiendaVirtual.Servicios;

import com.tiendaVirtual.tiendaVirtual.Modelo.Usuario;
import java.util.List;

/**
 *
 * @author danielgarcia
 */
public interface UsuarioServicio {
    public Usuario save(Usuario usuario); 
    public void delete(Integer id);
    public Usuario findById(Integer id); 
    public List<Usuario> findAll();
}
