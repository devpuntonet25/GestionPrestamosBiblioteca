package com.sistema.biblioteca.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {
    @Id
    @Column(name = "usuario_num_id")
    private Long numId;
    @Column(name = "usuario_nombre")
    private String nombre;
    @Column(name = "usuario_direccion")
    private String direccion;
    @Column(name = "usuario_nombre_usuario")
    private String nombreUsuario;
    @Column(name = "usuario_clave")
    private String clave;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private List<Prestamo> prestamoslist;
    //Nota: la relación bidireccional no funciona bien en relaciones OneToMany, tuve que quitar mappedBy = "usuario"
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TelefonoUsuario> telefonosUsuariosList;

    public List<TelefonoUsuario> getTelefonosUsuariosList() {
        return telefonosUsuariosList;
    }

    public void setTelefonosUsuariosList(List<TelefonoUsuario> telefonosUsuariosList) {
        this.telefonosUsuariosList = telefonosUsuariosList;
    }

    public Long getNumId() {
        return numId;
    }

    public void setNumId(Long numId) {
        this.numId = numId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Prestamo> getPrestamoslist() {
        return prestamoslist;
    }

    public void setPrestamoslist(List<Prestamo> prestamoslist) {
        this.prestamoslist = prestamoslist;
    }
}
