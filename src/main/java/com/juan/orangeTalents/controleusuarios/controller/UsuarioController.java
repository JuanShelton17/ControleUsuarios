package com.juan.orangeTalents.controleusuarios.controller;

import com.juan.orangeTalents.controleusuarios.dto.UsuarioDto;
import com.juan.orangeTalents.controleusuarios.exception.UsuarioNaoEncontradoException;
import com.juan.orangeTalents.controleusuarios.model.Usuario;
import com.juan.orangeTalents.controleusuarios.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDto>> getAll() {
        List<Usuario> allUsuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(allUsuarios.stream().map(Usuario::toDto).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        try {
            Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
            return ResponseEntity.ok(usuario.get().toDto());
        } catch (UsuarioNaoEncontradoException ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody @Valid UsuarioDto usuarioDto) {
        try {
            Usuario usuario = usuarioService.insertUsuario(usuarioDto);
            return ResponseEntity.created(URI.create(String.format("/usuarios/%s", usuario.getId()))).body(usuario.toDto());
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }
}
