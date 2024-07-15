package com.docconcierge.user_service.repository;

import com.docconcierge.user_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByDepartamentoId(Long departamentoId);
    List<Usuario> findByFilialId(Long filialId);
    Optional<Usuario> findByCpf(String cpf);
}
