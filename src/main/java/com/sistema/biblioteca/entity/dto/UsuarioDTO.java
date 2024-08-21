package com.sistema.biblioteca.entity.dto;

import com.sistema.biblioteca.entity.Prestamo;
import com.sistema.biblioteca.entity.TelefonoUsuario;

import java.util.List;

public class UsuarioDTO {
    private Long numId;
    private String nombre;
    private String direccion;
    private String nombreUsuario;
    private List<Prestamo> prestamoslist;
    private List<TelefonoUsuario> telefonosUsuariosList;

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

    public List<Prestamo> getPrestamoslist() {
        return prestamoslist;
    }

    public void setPrestamoslist(List<Prestamo> prestamoslist) {
        this.prestamoslist = prestamoslist;
    }

    public List<TelefonoUsuario> getTelefonosUsuariosList() {
        return telefonosUsuariosList;
    }

    public void setTelefonosUsuariosList(List<TelefonoUsuario> telefonosUsuariosList) {
        this.telefonosUsuariosList = telefonosUsuariosList;
    }
}
