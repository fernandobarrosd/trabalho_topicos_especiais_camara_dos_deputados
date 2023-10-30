package com.fernando.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.api.dtos.UsuarioRequestDTO;
import com.fernando.api.services.interfaces.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/signup")
    public ResponseEntity<Void> createUser(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioService.createUser(usuarioRequestDTO);
        return ResponseEntity.noContent().build();
    }
}
