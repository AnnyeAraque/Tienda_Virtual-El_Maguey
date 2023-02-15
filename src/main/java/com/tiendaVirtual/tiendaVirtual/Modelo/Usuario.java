
package com.tiendaVirtual.tiendaVirtual.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author danielgarcia
 */

@Table
@Entity(name="usuarios")
public class Usuario implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) 
        @Column(name="id_usuario")
        private Integer idUsuario;

        @Column(name="nombres") 
        private String nombres;

        @Column(name="apellidos") 
        private String apellidos;

        @Column(name="tipo_doc_identidad") 
        private String tipoDocIdentidad;

        @Column(name="num_doc_identidad") 
        private Integer numDocIdentidad;
        
        @Column(name="ciudad") 
        private String ciudad;
        
        @Column(name="barrio") 
        private String barrio;
        
        @Column(name="dir_domicilio") 
        private String dirDomicilio;
        
        @Column(name="nombre_usuario") 
        private String nombreUsuario;
        
        @Column(name="password") 
        private String password;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocIdentidad() {
        return tipoDocIdentidad;
    }

    public void setTipoDocIdentidad(String tipoDocIdentidad) {
        this.tipoDocIdentidad = tipoDocIdentidad;
    }

    public Integer getNumDocIdentidad() {
        return numDocIdentidad;
    }

    public void setNumDocIdentidad(Integer numDocIdentidad) {
        this.numDocIdentidad = numDocIdentidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDirDomicilio() {
        return dirDomicilio;
    }

    public void setDirDomicilio(String dirDomicilio) {
        this.dirDomicilio = dirDomicilio;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}