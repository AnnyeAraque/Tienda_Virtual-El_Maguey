
package com.tiendaVirtual.tiendaVirtual.Servicios.Implement;


import com.tiendaVirtual.tiendaVirtual.Dao.UsuarioDao;
import com.tiendaVirtual.tiendaVirtual.Modelo.Usuario;
import com.tiendaVirtual.tiendaVirtual.Servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danielgarcia
 */

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=false)
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        usuarioDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }
}
