package com.docconcierge.dep_filial_service.service;

import com.docconcierge.dep_filial_service.DTO.DepartamentoDTO;
import com.docconcierge.dep_filial_service.DTO.FilialDTO;
import com.docconcierge.dep_filial_service.model.Departamento;
import com.docconcierge.dep_filial_service.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento criarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public boolean existeDepartamentoComNome(String nome) {
        Optional<Departamento> departamento = departamentoRepository.findByNome(nome);
        return departamento.isPresent();
    }

    public DepartamentoDTO obterDepartamentoPorId(Long id) {
        Optional<Departamento> departamentoOpt = departamentoRepository.findById(id);
        if (departamentoOpt.isPresent()) {
            Departamento departamento = departamentoOpt.get();
            FilialDTO filialDTO = new FilialDTO(departamento.getFilial().getId(), departamento.getFilial().getNome());
            DepartamentoDTO departamentoDTO = new DepartamentoDTO(
                    departamento.getId(),
                    departamento.getNome(),
                    filialDTO
            );

            return departamentoDTO;
        }
        return null;
    }


    public Departamento atualizarDepartamento(Long id, Departamento departamentoDetalhes) {
        Departamento departamento = obterDepartamento(id);
        if (departamento == null) {
            return null;
        }

        // Verifica se o nome do departamento já existe, excluindo o próprio departamento atual
        if (!departamento.getNome().equals(departamentoDetalhes.getNome()) && existeDepartamentoComNome(departamentoDetalhes.getNome())) {
            throw new IllegalArgumentException("Departamento com esse nome já existe.");
        }

        departamento.setNome(departamentoDetalhes.getNome());
        return departamentoRepository.save(departamento);
    }

    public Departamento obterDepartamento(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public void deletarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }


    public List<DepartamentoDTO> listarDepartamentos() {
        List<Departamento> departamentos = departamentoRepository.findAll();
        return departamentos.stream()
                .map(departamento -> new DepartamentoDTO(
                        departamento.getId(),
                        departamento.getNome(),
                        new FilialDTO(departamento.getFilial().getId(), departamento.getFilial().getNome())
                ))
                .collect(Collectors.toList());
    }
}

