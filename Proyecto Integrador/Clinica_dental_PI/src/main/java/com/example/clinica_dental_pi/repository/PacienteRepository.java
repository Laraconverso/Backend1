package com.example.clinica_dental_pi.repository;

import com.example.clinica_dental_pi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}