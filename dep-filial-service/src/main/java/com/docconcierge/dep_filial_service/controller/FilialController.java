package com.docconcierge.dep_filial_service.controller;

import com.docconcierge.dep_filial_service.DTO.FilialDTO;
import com.docconcierge.dep_filial_service.model.Filial;
import com.docconcierge.dep_filial_service.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filiais")
public class FilialController {
    @Autowired
    private FilialService filialService;

    @PostMapping
    public ResponseEntity<Filial> criarFilial(@RequestBody Filial filial) {
        Filial novaFilial = filialService.criarFilial(filial);
        return ResponseEntity.ok(novaFilial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilialDTO> obterFilialPorId(@PathVariable Long id) {
        FilialDTO filialDTO = filialService.obterFilialPorId(id);
        if (filialDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filialDTO);
    }

    @GetMapping
    public ResponseEntity<List<FilialDTO>> listarFiliais() {
        List<FilialDTO> filiais = filialService.listarFiliais();
        return ResponseEntity.ok(filiais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filial> atualizarFilial(@PathVariable Long id, @RequestBody Filial filialDetalhes) {
        Filial filialAtualizada = filialService.atualizarFilial(id, filialDetalhes);
        if (filialAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filialAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilial(@PathVariable Long id) {
        boolean isDeleted = filialService.deletarFilial(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
