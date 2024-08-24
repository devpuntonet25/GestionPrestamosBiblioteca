package com.sistema.biblioteca.service;

import com.sistema.biblioteca.entity.Libro;
import com.sistema.biblioteca.repository.LibroRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
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
}
