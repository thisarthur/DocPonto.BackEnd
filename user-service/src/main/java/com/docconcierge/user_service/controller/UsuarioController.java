package com.docconcierge.user_service.controller;

import com.docconcierge.user_service.model.Usuario;
import com.docconcierge.user_service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario) {
        String result = usuarioService.saveUsuario(usuario);
        if (result.equals("Usuario já cadastrado")) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @GetMapping("/departamento/{departamentoId}")
    public List<Usuario> getUsuariosByDepartamento(@PathVariable Long departamentoId) {
        return usuarioService.getUsuariosByDepartamento(departamentoId);
    }

    @GetMapping("/filial/{filialId}")
    public List<Usuario> getUsuariosByFilial(@PathVariable Long filialId) {
        return usuarioService.getUsuariosByFilial(filialId);
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }
}
