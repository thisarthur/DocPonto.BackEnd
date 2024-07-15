package com.docconcierge.dep_filial_service.service;

import com.docconcierge.dep_filial_service.DTO.FilialDTO;
import com.docconcierge.dep_filial_service.model.Filial;
import com.docconcierge.dep_filial_service.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilialService {
    @Autowired
    private FilialRepository filialRepository;

    public Filial criarFilial(Filial filial) {
        return filialRepository.save(filial);
    }

    public FilialDTO obterFilialPorId(Long id) {
        Optional<Filial> filialOpt = filialRepository.findById(id);
        if (filialOpt.isPresent()) {
            Filial filial = filialOpt.get();
            return new FilialDTO(filial.getId(), filial.getNome());
        }
        return null;
    }

    public List<FilialDTO> listarFiliais() {
        return filialRepository.findAll().stream()
                .map(filial -> new FilialDTO(filial.getId(), filial.getNome()))
                .collect(Collectors.toList());
    }

    public Filial atualizarFilial(Long id, Filial filialDetalhes) {
        Filial filial = obterFilial(id);
        if (filial == null) {
            return null;
        }

        filial.setNome(filialDetalhes.getNome());
        return filialRepository.save(filial);
    }

    public boolean deletarFilial(Long id) {
        if (filialRepository.existsById(id)) {
            filialRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Filial obterFilial(Long id) {
        return filialRepository.findById(id).orElse(null);
    }

}
