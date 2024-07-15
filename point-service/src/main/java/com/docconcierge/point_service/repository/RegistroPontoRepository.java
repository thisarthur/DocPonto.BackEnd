package com.docconcierge.point_service.repository;

import com.docconcierge.point_service.model.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {
    List<RegistroPonto> findByUsuarioIdAndData(Long usuarioId, LocalDate data);
    List<RegistroPonto> findByUsuarioId(Long usuarioId);
}
