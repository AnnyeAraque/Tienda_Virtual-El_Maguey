
package com.tiendaVirtual.tiendaVirtual.Controlador;


import com.tiendaVirtual.tiendaVirtual.Modelo.Usuario;
import com.tiendaVirtual.tiendaVirtual.Servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danielgarcia
*/

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioservicio;

    @PostMapping(value="/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario){ 
        Usuario obj = usuarioservicio.save(usuario);
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer id){ 
    Usuario obj = usuarioservicio.findById(id);
    if(obj!=null)
        usuarioservicio.delete(id); 
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario){ 
    Usuario obj = usuarioservicio.findById(usuario.getIdUsuario()); 
    if(obj!=null){
        obj.setNombres(usuario.getNombres()); 
        obj.setApellidos(usuario.getApellidos()); 
        obj.setTipoDocIdentidad(usuario.getTipoDocIdentidad()); 
        obj.setNumDocIdentidad(usuario.getNumDocIdentidad());
        obj.setCiudad(usuario.getCiudad());
        obj.setBarrio(usuario.getBarrio());
        obj.setDirDomicilio(usuario.getDirDomicilio());
        obj.setNombreUsuario(usuario.getNombreUsuario());
        obj.setPassword(usuario.getPassword());
    usuarioservicio.save(obj); }
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Usuario> consultarTodo(){ 
    return usuarioservicio.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Usuario consultaPorId(@PathVariable Integer id){ 
        return usuarioservicio.findById(id);
    }
    
    @GetMapping("/info")
    public String info(){ 
        return "Prueba";
    }
}
