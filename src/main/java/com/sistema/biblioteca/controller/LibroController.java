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

    //It allows to get all libros and sorted in ASC or DESC order, and through one of the following attributes: titulo, categoria, valorAlquiler
    @GetMapping("/getAllLibrosSortedBy")
    public List<Libro> getAllLibrosSortedBy(@RequestParam String orden, @RequestParam String campo) {
        return libroService.getAllLibrosSortedBy(orden, campo);
    }

    //This help us on returning back a list of books limited by a number of rows and the page we want the books for
    //(It is basically the pagination for the Libros table)
    @GetMapping("/pagination")
    public List<Libro> getAllLibrosLimited(@RequestParam Integer pagina, @RequestParam Integer cantidadRegistros) {
       return libroService.getLimitedLibros(pagina, cantidadRegistros);
    }
}
