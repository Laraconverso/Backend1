package com.example.clinica_dental_pi.Repository;

import com.example.clinica_dental_pi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}