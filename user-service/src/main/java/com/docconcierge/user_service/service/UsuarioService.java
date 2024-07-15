package com.docconcierge.user_service.service;

import com.docconcierge.user_service.model.Usuario;
import com.docconcierge.user_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public String saveUsuario(Usuario usuario){
        Optional<Usuario> usuarioExistente = usuarioRepository.findByCpf(usuario.getCpf());
        if (usuarioExistente.isPresent()) {
            return "Usuario já cadastrado";
        }
        usuarioRepository.save(usuario);
        return "Usuario cadastrado com sucesso";
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        usuario.setNome(usuarioDetails.getNome());
        usuario.setCpf(usuarioDetails.getCpf());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setCargo(usuarioDetails.getCargo());
        usuario.setDescricaoHorario(usuarioDetails.getDescricaoHorario());
        usuario.setGestorResponsavel(usuarioDetails.getGestorResponsavel());
        usuario.setCargaHorariaSegunda(usuarioDetails.getCargaHorariaSegunda());
        usuario.setCargaHorariaTerca(usuarioDetails.getCargaHorariaTerca());
        usuario.setCargaHorariaQuarta(usuarioDetails.getCargaHorariaQuarta());
        usuario.setCargaHorariaQuinta(usuarioDetails.getCargaHorariaQuinta());
        usuario.setCargaHorariaSexta(usuarioDetails.getCargaHorariaSexta());
        usuario.setCargaHorariaSabado(usuarioDetails.getCargaHorariaSabado());
        usuario.setCargaHorariaDomingo(usuarioDetails.getCargaHorariaDomingo());
        usuario.setDepartamentoId(usuarioDetails.getDepartamentoId());
        usuario.setFilialId(usuarioDetails.getFilialId());
        usuario.setDataNascimento(usuarioDetails.getDataNascimento());
        usuario.setDataAdmissao(usuarioDetails.getDataAdmissao());
        usuario.setDataDemissao(usuarioDetails.getDataDemissao());
        usuario.setSenha(usuarioDetails.getSenha());
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Usuario> getUsuariosByDepartamento(Long departamentoId) {
        return usuarioRepository.findByDepartamentoId(departamentoId);
    }

    public List<Usuario> getUsuariosByFilial(Long filialId) {
        return usuarioRepository.findByFilialId(filialId);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}
