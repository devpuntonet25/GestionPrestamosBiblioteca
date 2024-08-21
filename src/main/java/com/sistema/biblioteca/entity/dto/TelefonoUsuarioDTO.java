package com.sistema.biblioteca.entity.dto;



public class TelefonoUsuarioDTO {
    private Long numId;
    private String telefono;

    public TelefonoUsuarioDTO() {
    }

    public TelefonoUsuarioDTO(Long numId, String telefono) {
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
}
