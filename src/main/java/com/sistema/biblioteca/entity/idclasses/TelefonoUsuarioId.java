package com.sistema.biblioteca.entity.idclasses;

import java.io.Serializable;
import java.util.Objects;

public class TelefonoUsuarioId implements Serializable {
    private Long numId;
    private String telefono;

    public TelefonoUsuarioId() {
    }

    public TelefonoUsuarioId(Long numId, String telefono) {
        this.numId = numId;
        this.telefono = telefono;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonoUsuarioId that = (TelefonoUsuarioId) o;
        return numId.equals(that.numId) && telefono.equals(that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numId, telefono);
    }
}
