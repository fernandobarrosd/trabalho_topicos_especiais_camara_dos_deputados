package com.fernando.api.services.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.fernando.api.dtos.UsuarioRequestDTO;

public interface UsuarioService extends UserDetailsService{
    void createUser(UsuarioRequestDTO usuarioRequestDTO);
}