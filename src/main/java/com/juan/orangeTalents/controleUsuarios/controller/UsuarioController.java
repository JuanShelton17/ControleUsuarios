package com.juan.orangeTalents.controleUsuarios.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juan.orangeTalents.controleUsuarios.dto.UsuarioDto;
import com.juan.orangeTalents.controleUsuarios.model.Usuario;
import com.juan.orangeTalents.controleUsuarios.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "getAllUsuarios", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> allUsuarios = usuarioService.getAllUsuarios();
		return ResponseEntity.ok(allUsuarios);
	}

	@RequestMapping(value = "getUsuarios/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Usuario>> getById(@PathVariable("id") Integer id) {
		Optional<Usuario> usuarioById = usuarioService.getUsuarioById(id);
		return ResponseEntity.ok(usuarioById);
	}

	@RequestMapping(value = "insertUsuarios", method = RequestMethod.POST)
	public ResponseEntity<Usuario> insert(@RequestBody @Valid UsuarioDto usuario) {
		Usuario insertUsuario = usuarioService.insertUsuario(usuario);
		return new ResponseEntity<Usuario>(insertUsuario, HttpStatus.CREATED);
	}
}
