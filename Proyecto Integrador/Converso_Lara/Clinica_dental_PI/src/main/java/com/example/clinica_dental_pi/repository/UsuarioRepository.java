package com.example.clinica_dental_pi.repository;

import com.example.clinica_dental_pi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Optional<Usuario> findByEmail(String email);

}