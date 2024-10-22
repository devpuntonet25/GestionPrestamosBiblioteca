package com.sistema.biblioteca.service;

import com.sistema.biblioteca.entity.Prestamo;
import com.sistema.biblioteca.entity.TelefonoUsuario;
import com.sistema.biblioteca.entity.Usuario;
import com.sistema.biblioteca.entity.dto.TelefonoUsuarioDTO;
import com.sistema.biblioteca.entity.dto.UsuarioDTO;
import com.sistema.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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

            //We need to take every User off from every Loan
            List<Prestamo> prestamoList = new ArrayList<>();
            for (Prestamo p : u.getPrestamoslist()) {
                p.setUsuario(null);
                prestamoList.add(p);
            }
            usuarioDTO.setPrestamoslist(prestamoList);
            //This avoids to show a list of json objects with no end because of the User field
            for (TelefonoUsuario telefonoUsuario : u.getTelefonosUsuariosList()) {
                usuarioDTO.addTelefonoUsuarioDTO(
                        new TelefonoUsuarioDTO(telefonoUsuario.getNumId(), telefonoUsuario.getTelefono())
                );
            }
            usuarioDTOS.add(usuarioDTO);
        }
        return usuarioDTOS;
    }
    public UsuarioDTO save(Usuario usuario) {

        //This assigns the user for every telephone
        usuario.getTelefonosUsuariosList().forEach(telefonoUsuario -> {
            telefonoUsuario.setUsuario(usuario);
        });

       //This encodes the raw password the user wants to save
       String encodedPassword = bCryptPasswordEncoder.encode(usuario.getClave());
       usuario.setClave(encodedPassword);

       //Then we can save the User with his encoded password
       Usuario u = usuarioRepository.save(usuario);

       //And we build our DTO so we do not return confidential information
       UsuarioDTO usuarioDTO = new UsuarioDTO();
       usuarioDTO.setNumId(u.getNumId());
       usuarioDTO.setNombre(u.getNombre());
       usuarioDTO.setDireccion(u.getDireccion());
       usuarioDTO.setNombreUsuario(u.getNombreUsuario());
       usuarioDTO.setPrestamoslist(u.getPrestamoslist());

       //This avoids to show a list of json objects with no end because of the User field
        for (TelefonoUsuario telefonoUsuario : u.getTelefonosUsuariosList()) {
            usuarioDTO.addTelefonoUsuarioDTO(
                    new TelefonoUsuarioDTO(telefonoUsuario.getNumId(), telefonoUsuario.getTelefono())
            );
        }
       return usuarioDTO;
    }
}
