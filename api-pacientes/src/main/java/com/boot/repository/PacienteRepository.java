package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
