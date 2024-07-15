package com.docconcierge.dep_filial_service.controller;

import com.docconcierge.dep_filial_service.DTO.DepartamentoDTO;
import com.docconcierge.dep_filial_service.model.Departamento;
import com.docconcierge.dep_filial_service.model.Filial;
import com.docconcierge.dep_filial_service.service.DepartamentoService;
import com.docconcierge.dep_filial_service.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private FilialService filialService;

    @PostMapping
    public ResponseEntity<String> criarDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        Filial filial = filialService.obterFilial(departamentoDTO.getFilial().getId());
        if (filial == null) {
            return ResponseEntity.badRequest().body("Filial não encontrada.");
        }

        if (departamentoService.existeDepartamentoComNome(departamentoDTO.getNome())) {
            return ResponseEntity.badRequest().body("Departamento com esse nome já existe.");
        }

        Departamento novoDepartamento = new Departamento();
        novoDepartamento.setNome(departamentoDTO.getNome());
        novoDepartamento.setFilial(filial);
        departamentoService.criarDepartamento(novoDepartamento);

        return ResponseEntity.ok("Departamento criado com sucesso.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> obterDepartamentoPorId(@PathVariable Long id) {
        DepartamentoDTO departamentoDTO = departamentoService.obterDepartamentoPorId(id);
        if (departamentoDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departamentoDTO);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> listarDepartamentos() {
        List<DepartamentoDTO> departamentos = departamentoService.listarDepartamentos();
        return ResponseEntity.ok(departamentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamentoExistente = departamentoService.obterDepartamento(id);
        if (departamentoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        departamentoExistente.setNome(departamentoDTO.getNome());

        try {
            departamentoService.atualizarDepartamento(id, departamentoExistente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("Departamento atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }

}

