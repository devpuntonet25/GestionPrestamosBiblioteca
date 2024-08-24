package com.sistema.biblioteca.repository;

import com.sistema.biblioteca.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
