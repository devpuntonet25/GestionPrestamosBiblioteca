package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.entity.Autor;
import com.sistema.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    //Saves an author
    @PostMapping("/save")
    public Autor save(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    //Updates and author
    @PutMapping("/update")
    public Autor update(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    //It gets all the authors
    @GetMapping("/all")
    public List<Autor> getAll() {
       return autorService.getAll();
    }

    //It gets all the authors which have a specified named
    @GetMapping("/getByName/{nombre}")
    public List<Autor> getAllByName(@PathVariable String nombre) {
        return autorService.getAllByName(nombre);
    }

    //It gets all the authors which have a specified citizenship
    @GetMapping("/getByCitizenship/{nacionalidad}")
    public List<Autor> getAllByCitizenship(@PathVariable String nacionalidad) {
        return autorService.getAllByCitizenship(nacionalidad);
    }

    //It gets all the authors which have a specified named and citizenship
    @GetMapping("/getByNameAndCitizenship")
    public List<Autor> getAllByNameAndCitizenship(@RequestParam String nombre, @RequestParam String nacionalidad) {
       return autorService.getAllByNameAndCitizenship(nombre, nacionalidad);
    }

    //It gets all the authors order in some determined order and through some attributes of the author
    @GetMapping("/getAllOrderBy")
    public List<Autor> getAllAuthorsOrderBy(@RequestParam String orden, @RequestParam String campo) {
        return autorService.getAllAuthorsOrderBy(orden, campo);
    }

    //It gets the authors starting in a determined position(first argument), and from that position the following number of rows specified on the second argument
    @GetMapping("/getLimitRows")
    public List<Autor> getLimitAuthors(@RequestParam Integer pagina, @RequestParam Integer cantidadRegistros) {
      return autorService.getlimitedAuthors(pagina, cantidadRegistros);
    }
}
