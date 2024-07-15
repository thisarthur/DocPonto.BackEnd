package com.docconcierge.point_service.controller;

import com.docconcierge.point_service.model.BancoHoras;
import com.docconcierge.point_service.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bancohoras")
public class BancoHorasController {

    @Autowired
    private BancoHorasService bancoHorasService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<BancoHoras>> obterBancoHorasPorUsuario(@PathVariable Long usuarioId) {
        List<BancoHoras> bancoHoras = bancoHorasService.obterBancoHorasPorUsuario(usuarioId);
        return ResponseEntity.ok(bancoHoras);
    }
}
