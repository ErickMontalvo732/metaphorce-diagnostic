package com.metaphorce.user.service;

import com.metaphorce.databaseLib.entity.Usuario;
import com.metaphorce.databaseLib.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private static UsuarioRepository usuarioRepository;


    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }

}