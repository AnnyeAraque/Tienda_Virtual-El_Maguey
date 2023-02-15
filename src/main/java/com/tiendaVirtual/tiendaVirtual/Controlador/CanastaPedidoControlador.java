
package com.tiendaVirtual.tiendaVirtual.Controlador;

import com.tiendaVirtual.tiendaVirtual.Modelo.CanastaPedido;
import com.tiendaVirtual.tiendaVirtual.Servicios.CanastaPedidoServicio;
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
@RequestMapping("/canastaPedido")
public class CanastaPedidoControlador {
    @Autowired
    private CanastaPedidoServicio canastapedidoservicio;

    @PostMapping(value="/")
    public ResponseEntity<CanastaPedido> agregar(@RequestBody CanastaPedido canastaPedido){ 
        CanastaPedido obj = canastapedidoservicio.save(canastaPedido);
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<CanastaPedido> eliminar(@PathVariable Integer id){ 
    CanastaPedido obj = canastapedidoservicio.findById(id);
    if(obj!=null)
        canastapedidoservicio.delete(id); 
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<CanastaPedido> editar(@RequestBody CanastaPedido canastaPedido){ 
    CanastaPedido obj = canastapedidoservicio.findById(canastaPedido.getIdPedido()); 
    if(obj!=null){
        obj.setCantProductoPedido(canastaPedido.getCantProductoPedido()); 
        obj.setTotalProductosPedidos(canastaPedido.getTotalProductosPedidos());
        obj.setTotalVenta(canastaPedido.getTotalVenta());
        obj.setFormaPago(canastaPedido.getFormaPago());
        obj.setMetodoEntrega(canastaPedido.getMetodoEntrega());
        obj.setFechaVenta(canastaPedido.getFechaVenta());
        obj.setDomicilioEntrega(canastaPedido.getDomicilioEntrega());
    canastapedidoservicio.save(obj); }
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<CanastaPedido> consultarTodo(){ 
    return canastapedidoservicio.findAll();
    }
    
    @GetMapping("/list/{id}")
    public CanastaPedido consultaPorId(@PathVariable Integer id){ 
        return canastapedidoservicio.findById(id);
    }
}
