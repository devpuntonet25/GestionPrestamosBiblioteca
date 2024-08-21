package com.sistema.biblioteca.service;

import com.sistema.biblioteca.entity.Autor;
import com.sistema.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    private AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    public List<Autor> getAllByName(String nombre) {
        return autorRepository.findByNombre(nombre);
    }

    public List<Autor> getAllByCitizenship(String nacionalidad) {
        //We remove the last letter, so the gender does not matter to fetch the authors
        char[] arrNacionalidad = nacionalidad.toCharArray();
        String nacionalidadSinUltimaLetra = "";

        for(short k = 0; k < arrNacionalidad.length - 1; k++) {
            nacionalidadSinUltimaLetra += arrNacionalidad[k];
        }
        return autorRepository.findByNacionalidad(nacionalidadSinUltimaLetra);
    }

    public List<Autor> getAllByNameAndCitizenship(String nombre, String nacionalidad) {
        return autorRepository.findByNombreAndNacionalidad(nombre, nacionalidad);
    }

    public List<Autor> getAllAuthorsOrderBy(String orden, String campo) {
        List<Autor> unorganizedList = autorRepository.findAll();
        switch (orden.toUpperCase()) {
            case "ASC":
                switch (campo.toLowerCase()) {
                    case "nombre" -> unorganizedList.sort((autorA, autorB) -> autorA.getNombre().compareTo(autorB.getNombre()));
                    case "nacionalidad" -> unorganizedList.sort((autorA, autorB) -> autorA.getNacionalidad().compareTo(autorB.getNacionalidad()));
                }
            break;
            case "DESC":
                switch (campo.toLowerCase()) {
                    case "nombre" -> unorganizedList.sort((autorA, autorB) -> autorB.getNombre().compareTo(autorA.getNombre()));
                    case "nacionalidad" -> unorganizedList.sort((autorA, autorB) -> autorB.getNacionalidad().compareTo(autorA.getNacionalidad()));
                }
        }
        return unorganizedList;
    }

    public List<Autor> getlimitedAuthors(Integer pagina, Integer cantidadRegistros) {
        //El siguiente código determina desde qué posición se deben tomar n cantidad de registros para hacer la paginación
        /*List<Autor> autorList = new ArrayList<>();
        if (pagina.equals(1)) {
            Pageable pageable = PageRequest.of(0, cantidadRegistros);
            autorList = autorRepository.getLimitedAuthors(pageable);
        } else {
            Integer offset = (cantidadRegistros * pagina) - cantidadRegistros;
            Pageable pageable = PageRequest.of(offset, cantidadRegistros);
            autorList = autorRepository.getLimitedAuthors(pageable);
        }*/

        Pageable pageable = PageRequest.of(pagina - 1, cantidadRegistros);
        return autorRepository.getLimitedAuthors(pageable);
    }
}
