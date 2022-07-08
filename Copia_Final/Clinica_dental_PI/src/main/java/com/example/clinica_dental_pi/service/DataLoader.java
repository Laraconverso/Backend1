package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.repository.UsuarioRepository;
import com.example.clinica_dental_pi.model.Usuario;
import com.example.clinica_dental_pi.model.UsuarioRol;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //encripto las passwords
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("admin");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("user");

        //Creo los usuarios
        Usuario usuario = new Usuario("Admin", "admin", "admin@digital.com", password, UsuarioRol.ADMIN);
        Usuario usuario2 = new Usuario("User", "user", "user@digital.com", password2, UsuarioRol.USER);
        this.usuarioRepository.save(usuario);
        this.usuarioRepository.save(usuario2);
    }
}
