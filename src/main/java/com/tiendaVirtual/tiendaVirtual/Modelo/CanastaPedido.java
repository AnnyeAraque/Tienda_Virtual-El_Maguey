/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaVirtual.tiendaVirtual.Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author danielgarcia
 */

@Table
@Entity(name="canastaPedido")
public class CanastaPedido implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id_pedido")
        private Integer idPedido;
        
        @ManyToOne 
        @JoinColumn(name="id_usuario") 
        private Usuario usuario;

        @Column(name="cant_producto_pedido") 
        private Integer cantProductoPedido;

        @Column(name="total_productos_pedidos") 
        private Integer totalProductosPedidos;

        @Column(name="total_venta") 
        private float totalVenta;

        @Column(name="forma_pago") 
        private String formaPago;
        
        @Column(name="metodo_entrega") 
        private String metodoEntrega;
        
        @Column(name="fecha_venta") 
        private Date fechaVenta;
        
        @Column(name="domicilio_entrega") 
        private String domicilioEntrega;

    public Integer getIdPedido() {
        return idPedido;
    }

    public Integer getCantProductoPedido() {
        return cantProductoPedido;
    }

    public void setCantProductoPedido(Integer cantProductoPedido) {
        this.cantProductoPedido = cantProductoPedido;
    }

    public Integer getTotalProductosPedidos() {
        return totalProductosPedidos;
    }

    public void setTotalProductosPedidos(Integer totalProductosPedidos) {
        this.totalProductosPedidos = totalProductosPedidos;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getMetodoEntrega() {
        return metodoEntrega;
    }

    public void setMetodoEntrega(String metodoEntrega) {
        this.metodoEntrega = metodoEntrega;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getDomicilioEntrega() {
        return domicilioEntrega;
    }

    public void setDomicilioEntrega(String domicilioEntrega) {
        this.domicilioEntrega = domicilioEntrega;
    }     
}