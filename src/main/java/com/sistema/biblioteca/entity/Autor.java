package com.sistema.biblioteca.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_autor")
public class Autor implements Comparable<Autor>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Long idAutor;
    @Column(name = "autor_nombre")
    private String nombre;
    @Column(name = "autor_nacionalidad")
    private String nacionalidad;
    /*@OneToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Libro> librosList;*/

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public int compareTo(Autor a) {
        return nombre.compareTo(a.nombre);
    }
    /*
    public List<Libro> getLibrosList() {
        return librosList;
    }

    public void setLibrosList(List<Libro> librosList) {
        this.librosList = librosList;
    }*/

}
