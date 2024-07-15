package com.docconcierge.dep_filial_service.repository;

import com.docconcierge.dep_filial_service.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByNome(String nome);
}
