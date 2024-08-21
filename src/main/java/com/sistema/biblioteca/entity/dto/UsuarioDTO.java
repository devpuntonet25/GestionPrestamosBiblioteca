package com.sistema.biblioteca.entity.dto;

import com.sistema.biblioteca.entity.Prestamo;
import com.sistema.biblioteca.entity.TelefonoUsuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    private Long numId;
    private String nombre;
    private String direccion;
    private String nombreUsuario;
    private List<Prestamo> prestamoslist;
    private List<TelefonoUsuarioDTO> telefonosUsuariosList = new ArrayList<>();

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

    public List<TelefonoUsuarioDTO> getTelefonosUsuariosList() {
        return telefonosUsuariosList;
    }

    public void setTelefonosUsuariosList(List<TelefonoUsuarioDTO> telefonosUsuariosList) {
        this.telefonosUsuariosList = telefonosUsuariosList;
    }

    public void addTelefonoUsuarioDTO(TelefonoUsuarioDTO telefonoUsuarioDTO) {
        telefonosUsuariosList.add(telefonoUsuarioDTO);
    }
}
