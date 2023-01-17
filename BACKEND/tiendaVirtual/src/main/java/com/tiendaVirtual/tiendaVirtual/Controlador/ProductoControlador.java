
package com.tiendaVirtual.tiendaVirtual.Controlador;


import com.tiendaVirtual.tiendaVirtual.Modelo.Producto;
import com.tiendaVirtual.tiendaVirtual.Servicios.ProductoServicio;
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
@RequestMapping("/productos")
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoservicio;

    @PostMapping(value="/")
    public ResponseEntity<Producto> agregar(@RequestBody Producto producto){ 
        Producto obj = productoservicio.save(producto);
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Integer id){ 
    Producto obj = productoservicio.findById(id);
    if(obj!=null)
        productoservicio.delete(id); 
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Producto> editar(@RequestBody Producto producto){ 
    Producto obj = productoservicio.findById(producto.getIdProducto()); 
    if(obj!=null){
        obj.setNombreProducto(producto.getNombreProducto()); 
        obj.setInfoProducto(producto.getInfoProducto()); 
        obj.setPrecioProducto(producto.getPrecioProducto()); 
        obj.setRefImagen(producto.getRefImagen());
        obj.setCatProducto(producto.getCatProducto());
        obj.setDescCompraProducto(producto.getDescCompraProducto());
        obj.setPorcentajeDesc(producto.getPorcentajeDesc());
        obj.setEstadoCatalogo(producto.getEstadoCatalogo());
    productoservicio.save(obj); }
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Producto> consultarTodo(){ 
    return productoservicio.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Producto consultaPorId(@PathVariable Integer id){ 
        return productoservicio.findById(id);
    }
}
