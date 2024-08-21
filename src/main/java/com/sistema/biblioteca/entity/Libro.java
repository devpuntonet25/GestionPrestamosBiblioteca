package com.sistema.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties({"prestamosList"})
@Entity
@Table(name = "tbl_libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_isbn")
    private Long isbn;
    @Column(name = "libro_titulo")
    private String titulo;
    @Column(name = "libro_categoria")
    private String categoria;
    @Column(name = "libro_valor_alquiler")
    private Double valorAlquiler;
    @Column(name = "libro_disponible")
    private Boolean disponible;
    @Column(name = "libro_cantidad")
    private Integer cantidad;
    @Column(name = "libro_porcentaje_descuento")
    private Double porcentajeDescuento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", referencedColumnName = "autor_id")
    private Autor autor;
    @ManyToMany()
    private List<Prestamo> prestamosList;

    public List<Prestamo> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamo> prestamosList) {
        this.prestamosList = prestamosList;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValorAlquiler() {
        return valorAlquiler;
    }

    public void setValorAlquiler(Double valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
