package com.docconcierge.point_service.service;

import com.docconcierge.point_service.model.BancoHoras;
import com.docconcierge.point_service.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BancoHorasService {

    @Autowired
    private BancoHorasRepository bancoHorasRepository;

    public List<BancoHoras> obterBancoHorasPorUsuario(Long usuarioId) {
        return bancoHorasRepository.findByUsuarioId(usuarioId);
    }
}
