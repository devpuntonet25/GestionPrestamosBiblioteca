package com.sistema.biblioteca.repository;

import com.sistema.biblioteca.entity.TelefonoUsuario;
import com.sistema.biblioteca.entity.idclasses.TelefonoUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoUsuarioRepository extends JpaRepository<TelefonoUsuario, TelefonoUsuarioId> {
}
