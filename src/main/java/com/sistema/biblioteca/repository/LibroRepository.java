package com.sistema.biblioteca.repository;

import com.sistema.biblioteca.entity.Libro;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("""
            SELECT l FROM Libro l WHERE LOWER(l.titulo) LIKE CONCAT('%',LOWER(?1),'%')
            """)
    List<Libro> getAllLibrosWhichTitleContains(String palabraClave);

    @Query("""
            SELECT l FROM Libro l WHERE LOWER(l.titulo) LIKE CONCAT('%',LOWER(?1),'%') AND l.disponible = TRUE AND l.cantidad > 1
            """)
    List<Libro> getAllLibrosWhichTitleContainsAndAreAvailable(String palabraClave);

    @Query("""
            SELECT l FROM Libro l 
            """)
    List<Libro> getLimitedLibros(Pageable pageable);
}
