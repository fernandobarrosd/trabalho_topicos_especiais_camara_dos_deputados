package com.fernando.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.api.entidades.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsername(String username);
}