package com.sistema.biblioteca.entity;

import com.sistema.biblioteca.entity.idclasses.TelefonoUsuarioId;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(TelefonoUsuarioId.class)//Esto es con el fin de crear la clave compuesta
@Table(name = "tbl_telefono_usuario")
public class TelefonoUsuario {
    @Id
    private Long numId;
    @Id
    private String telefono;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_num_id")
    private Usuario usuario;

    public Long getNumId() {
        return numId;
    }

    public void setNumId(Long numId) {
        this.numId = numId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
