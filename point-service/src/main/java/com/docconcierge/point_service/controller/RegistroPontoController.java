package com.docconcierge.point_service.controller;

import com.docconcierge.point_service.DTO.RegistroPontoDTO;
import com.docconcierge.point_service.model.RegistroPonto;
import com.docconcierge.point_service.model.TipoPonto;
import com.docconcierge.point_service.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registroponto")
public class RegistroPontoController {

    @Autowired
    private PontoService pontoService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPonto(@RequestParam Long usuarioId, @RequestParam TipoPonto tipo) {
        pontoService.registrarPonto(usuarioId, tipo);
        return ResponseEntity.ok("Ponto registrado com sucesso");
    }

    @GetMapping("/{usuarioId}/registros")
    public ResponseEntity<List<RegistroPontoDTO>> obterRegistrosPorUsuario(@PathVariable Long usuarioId) {
        List<RegistroPonto> registros = pontoService.obterRegistrosPorUsuario(usuarioId);
        if (registros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<RegistroPontoDTO> registrosDTO = registros.stream()
                .map(registro -> new RegistroPontoDTO(
                        registro.getId(),
                        registro.getUsuarioId(),
                        registro.getData(),
                        registro.getHorario(),
                        registro.getTipo()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(registrosDTO);
    }
}
