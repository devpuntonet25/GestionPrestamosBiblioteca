package com.sistema.biblioteca.service;

import com.sistema.biblioteca.entity.Usuario;
import com.sistema.biblioteca.entity.dto.UsuarioDTO;
import com.sistema.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        for(Usuario u : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNumId(u.getNumId());
            usuarioDTO.setNombre(u.getNombre());
            usuarioDTO.setDireccion(u.getDireccion());
            usuarioDTO.setNombreUsuario(u.getNombreUsuario());
            usuarioDTO.setPrestamoslist(u.getPrestamoslist());
            usuarioDTO.setTelefonosUsuariosList(u.getTelefonosUsuariosList());
            usuarioDTOS.add(usuarioDTO);
        }
        return usuarioDTOS;
    }
    public UsuarioDTO save(Usuario usuario) {
       Usuario u = usuarioRepository.save(usuario);
       UsuarioDTO usuarioDTO = new UsuarioDTO();
       usuarioDTO.setNumId(u.getNumId());
       usuarioDTO.setNombre(u.getNombre());
       usuarioDTO.setDireccion(u.getDireccion());
       usuarioDTO.setNombreUsuario(u.getNombreUsuario());
       usuarioDTO.setPrestamoslist(u.getPrestamoslist());
       usuarioDTO.setTelefonosUsuariosList(u.getTelefonosUsuariosList());
       return usuarioDTO;
    }
}
