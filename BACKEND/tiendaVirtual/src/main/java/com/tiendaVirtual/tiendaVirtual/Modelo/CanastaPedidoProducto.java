
package com.tiendaVirtual.tiendaVirtual.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author danielgarcia
 */

@Table
@Entity(name="canastaPedidoProducto")
public class CanastaPedidoProducto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_canasta_pedido_producto")
    private Integer idCanastaPedidoProducto;
    
    @ManyToOne 
    @JoinColumn(name="id_pedido") 
    private CanastaPedido canastaPedido;

    @ManyToOne 
    @JoinColumn(name="id_producto") 
    private Producto producto;

    public Integer getIdCanastaPedidoProducto() {
        return idCanastaPedidoProducto;
    }

    public CanastaPedido getCanastaPedido() {
        return canastaPedido;
    }

    public void setCanastaPedido(CanastaPedido canastaPedido) {
        this.canastaPedido = canastaPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}