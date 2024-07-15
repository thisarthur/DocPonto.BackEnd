package com.docconcierge.dep_filial_service.repository;

import com.docconcierge.dep_filial_service.model.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilialRepository extends JpaRepository<Filial, Long> {
    Optional<Filial> findByNome(String nome);
}
