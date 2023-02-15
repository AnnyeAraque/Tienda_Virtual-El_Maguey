
package com.tiendaVirtual.tiendaVirtual.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author danielgarcia
 */
@Table
@Entity(name="productos")
public class Producto implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id_producto")
        private Integer idProducto;

        @Column(name="nombre_producto") 
        private String nombreProducto;

        @Column(name="info_producto") 
        private String infoProducto;

        @Column(name="precio_producto") 
        private float precioProducto;

        @Column(name="ref_imagen") 
        private String refImagen;
        
        @Column(name="cat_producto") 
        private String catProducto;
        
        @Column(name="desc_compra_producto") 
        private Integer descCompraProducto;
        
        @Column(name="porcentaje_desc") 
        private float porcentajeDesc;
        
        @Column(name="estado_catalogo") 
        private Integer estadoCatalogo;

    public Integer getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getInfoProducto() {
        return infoProducto;
    }

    public void setInfoProducto(String infoProducto) {
        this.infoProducto = infoProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getRefImagen() {
        return refImagen;
    }

    public void setRefImagen(String refImagen) {
        this.refImagen = refImagen;
    }

    public String getCatProducto() {
        return catProducto;
    }

    public void setCatProducto(String catProducto) {
        this.catProducto = catProducto;
    }

    public Integer getDescCompraProducto() {
        return descCompraProducto;
    }

    public void setDescCompraProducto(Integer descCompraProducto) {
        this.descCompraProducto = descCompraProducto;
    }

    public float getPorcentajeDesc() {
        return porcentajeDesc;
    }

    public void setPorcentajeDesc(float porcentajeDesc) {
        this.porcentajeDesc = porcentajeDesc;
    }

    public Integer getEstadoCatalogo() {
        return estadoCatalogo;
    }

    public void setEstadoCatalogo(Integer estadoCatalogo) {
        this.estadoCatalogo = estadoCatalogo;
    }    
}
