
package com.tiendaVirtual.tiendaVirtual.Controlador;

import com.tiendaVirtual.tiendaVirtual.Modelo.CanastaPedidoProducto;
import com.tiendaVirtual.tiendaVirtual.Servicios.CanastaPedidoProductoServicio;
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
@RequestMapping("/canastaPedidoProducto")
public class CanastaPedidoProductoControlador {
    @Autowired
    private CanastaPedidoProductoServicio canastapedidoproductoservicio;

    @PostMapping(value="/")
    public ResponseEntity<CanastaPedidoProducto> agregar(@RequestBody CanastaPedidoProducto canastaPedidoProducto){ 
        CanastaPedidoProducto obj = canastapedidoproductoservicio.save(canastaPedidoProducto);
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<CanastaPedidoProducto> eliminar(@PathVariable Integer id){ 
    CanastaPedidoProducto obj = canastapedidoproductoservicio.findById(id);
    if(obj!=null)
        canastapedidoproductoservicio.delete(id); 
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<CanastaPedidoProducto> editar(@RequestBody CanastaPedidoProducto canastaPedidoProducto){ 
    CanastaPedidoProducto obj = canastapedidoproductoservicio.findById(canastaPedidoProducto.getIdCanastaPedidoProducto()); 
    if(obj!=null){
        obj.setCanastaPedido(canastaPedidoProducto.getCanastaPedido()); 
        obj.setProducto(canastaPedidoProducto.getProducto()); 
    canastapedidoproductoservicio.save(obj); }
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<CanastaPedidoProducto> consultarTodo(){ 
    return canastapedidoproductoservicio.findAll();
    }
    
    @GetMapping("/list/{id}")
    public CanastaPedidoProducto consultaPorId(@PathVariable Integer id){ 
        return canastapedidoproductoservicio.findById(id);
    }
}
