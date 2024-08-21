package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.entity.Usuario;
import com.sistema.biblioteca.entity.dto.UsuarioDTO;
import com.sistema.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //It stores a new user inside the Usuario table
    @PostMapping("/save")
    public UsuarioDTO save(@RequestBody Usuario usuario) {
       return usuarioService.save(usuario);
    }

    //It gets all the User from the Usuario table, but it does not show the password for any User
    @GetMapping("/findAll")
    public List<UsuarioDTO> findAll() {
        return usuarioService.getAll();
    }
}
