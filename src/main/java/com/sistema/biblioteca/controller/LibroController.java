package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.entity.Libro;
import com.sistema.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {
    private LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping("/save")
    public Libro save(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    /*Este endpoint permite obtener una lista de libros de los cuales el titulo contenga alguna palabra clave*/
    @GetMapping("/titleContains/{palabraClave}")
    public List<Libro> getAllLibrosWhichTitleContains(@PathVariable String palabraClave) {
        return libroService.getAllLibrosWhichTitleContains(palabraClave);
    }

    /*Este endpoint busca libros los cuales su titulo contenga alguna palabra clave y además estén disponibles*/
    @GetMapping("/titleContainsAndAvailable/{palabraClave}")
    public List<Libro> getAllLibrosWhichTitleContainsAndAreAvailable(@PathVariable String palabraClave) {
        return libroService.getAllLibrosWhichTitleContainsAndAreAvailable(palabraClave);
    }
}
