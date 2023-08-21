package com.mt.parkapi.service;

import com.mt.parkapi.entity.Usuario;
import com.mt.parkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Transactional(readOnly = true)
    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")) ;
    }
    @Transactional
    public Usuario updatePassword(Long id, String password) {
        Usuario user = getUserById(id);
        user.setPassword(password);
        return user;
    }
    @Transactional(readOnly = true)
    public List<Usuario> getAllUser() {
        return usuarioRepository.findAll();
    }
}
