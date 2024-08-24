package com.sistema.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestamo_id")
    private Long idPrestamo;
    @Column(name = "prestamo_fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "prestamo_fecha_dev_esperada")
    private LocalDate fechaDevolucionEsperada;
    @Column(name = "prestamo_fecha_dev_real")
    private LocalDate fechaDevolucionReal;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "factura_id", referencedColumnName = "factura_id")
    private Factura factura;
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_libro_prestamo",
            joinColumns = @JoinColumn(name = "prestamo_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_isbn")
    )
    //@JsonBackReference//This avoids infinite recursion
    private List<Libro> librosList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Usuario usuario;

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(LocalDate fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public List<Libro> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libro> librosList) {
        this.librosList = librosList;
    }
}
