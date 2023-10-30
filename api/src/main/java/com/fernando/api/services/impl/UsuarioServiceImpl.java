package com.fernando.api.services.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fernando.api.dtos.UsuarioRequestDTO;
import com.fernando.api.entidades.Usuario;
import com.fernando.api.repositorios.UsuarioRepository;
import com.fernando.api.services.interfaces.UsuarioService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return  usuarioRepository.findByUsername(username)
       .orElseThrow(() -> 
       new EntityNotFoundException("User is not exists"));
    }

    @Override
    public void createUser(UsuarioRequestDTO usuarioRequestDTO) {
        Optional<Usuario> usuarOptional = usuarioRepository.findByUsername(usuarioRequestDTO.username());

        if (usuarOptional.isPresent()) {
            throw new EntityExistsException("User is already exists");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioRequestDTO.username());
        usuario.setPassword(passwordEncoder.encode(
            usuarioRequestDTO.password()
        ));

        usuarioRepository.save(usuario);
    }
    
}
