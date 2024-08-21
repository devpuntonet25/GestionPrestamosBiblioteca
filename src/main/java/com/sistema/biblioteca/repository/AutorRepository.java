package com.sistema.biblioteca.repository;

import com.sistema.biblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    /*@Query("""
            SELECT 
            a, 
            l.isbn, 
            l.titulo, 
            l.categoria, 
            l.valorAlquiler, 
            l.disponible, 
            l.cantidad,
            l.porcentajeDescuento
            FROM Autor a JOIN Libro l on a.idAutor = l.autor.idAutor
            """)
    List<Autor> findAll();*/

    List<Autor> findByNombre(String nombre);
    @Query("""
            SELECT a From Autor a WHERE LOWER(a.nacionalidad) like CONCAT(LOWER(?1), '%')
            """)
    List<Autor> findByNacionalidad(String nacionalidad);
    @Query("""
            SELECT a From Autor a WHERE LOWER(a.nombre) = LOWER(?1) AND LOWER(a.nacionalidad) = LOWER(?2)
            """)
    List<Autor> findByNombreAndNacionalidad(String nombre, String nacionalidad);

    @Query("""
            SELECT a FROM Autor a
            """)
    List<Autor> getLimitedAuthors(Pageable pageable);
}
