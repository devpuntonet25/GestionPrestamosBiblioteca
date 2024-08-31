package com.sistema.biblioteca.service;

import com.sistema.biblioteca.entity.Libro;
import com.sistema.biblioteca.repository.LibroRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {
    private LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> getAllLibrosWhichTitleContains(String palabraClave) {
        List<Libro> librosList = libroRepository.getAllLibrosWhichTitleContains(palabraClave);
        /*for (Libro l : librosList) {
            Hibernate.initialize(l.getPrestamosList());
        }*/
        return librosList;
    }

    public List<Libro> getAllLibrosWhichTitleContainsAndAreAvailable(String palabraClave) {
        return libroRepository.getAllLibrosWhichTitleContainsAndAreAvailable(palabraClave);
    }

    //This help us to sort a list of books by one determined attribute and in some specific order
    public List<Libro> getAllLibrosSortedBy(String orden, String campo) {
        List<Libro> librosList = libroRepository.findAll();
        switch (orden.toUpperCase()) {
            case "ASC":
                switch (campo.toUpperCase()) {
                    case "TITULO" -> librosList.sort((libroA, libroB) -> libroA.getTitulo().compareTo(libroB.getTitulo()));
                    case "CATEGORIA" -> librosList.sort((libroA, libroB) -> libroA.getCategoria().compareTo(libroB.getCategoria()));
                    case "VALORALQUILER" -> librosList.sort((libroA, libroB) -> libroA.getValorAlquiler().compareTo(libroB.getValorAlquiler()));
                }
                break;
            case "DESC":
                switch (campo.toUpperCase()) {
                    case "TITULO" -> librosList.sort((libroA, libroB) -> libroB.getTitulo().compareTo(libroA.getTitulo()));
                    case "CATEGORIA" -> librosList.sort((libroA, libroB) -> libroB.getCategoria().compareTo(libroA.getCategoria()));
                    case "VALORALQUILER" -> librosList.sort((libroA, libroB) -> libroB.getValorAlquiler().compareTo(libroA.getValorAlquiler()));
                }

        }
        return librosList;
    }

    //This help us on returning back a list of books limited by a number of rows and the page we want the books for
    //(It is basically the pagination for the Libros table)
    public List<Libro> getLimitedLibros(Integer pagina, Integer cantidadRegistros) {
        Pageable pageable = PageRequest.of(pagina - 1, cantidadRegistros);
        return libroRepository.getLimitedLibros(pageable);
    }
}
