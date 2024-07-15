package com.docconcierge.point_service.repository;

import com.docconcierge.point_service.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long> {
    Optional<BancoHoras> findByUsuarioIdAndData(Long usuarioId, LocalDate data);
    List<BancoHoras> findByUsuarioId(Long usuarioId);
}
