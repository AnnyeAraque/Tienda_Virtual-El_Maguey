
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

        @Column(name="email") 
        private String email;
        
        @Column(name="dir_domicilio") 
        private String dirDomicilio;
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirDomicilio() {
        return dirDomicilio;
    }

    public void setDirDomicilio(String dirDomicilio) {
        this.dirDomicilio = dirDomicilio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}