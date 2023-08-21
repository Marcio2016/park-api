package com.mt.parkapi.Controller;

import com.mt.parkapi.dto.UsuarioCreateDto;
import com.mt.parkapi.dto.UsuarioResponseDto;
import com.mt.parkapi.dto.mapper.UsuarioMapper;
import com.mt.parkapi.entity.Usuario;
import com.mt.parkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDto usuarioDto){
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(usuarioDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }


    @GetMapping()
    public ResponseEntity<List<Usuario>> getAllUser(){
        List<Usuario> user = usuarioService.getAllUser();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id){
        Usuario user = usuarioService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioService.updatePassword(id, usuario.getPassword());
        return ResponseEntity.ok(user);
    }
}
