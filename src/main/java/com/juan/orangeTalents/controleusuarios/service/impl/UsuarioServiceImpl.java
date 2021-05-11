package com.juan.orangeTalents.controleusuarios.service.impl;

import com.juan.orangeTalents.controleusuarios.dto.UsuarioDto;
import com.juan.orangeTalents.controleusuarios.model.Usuario;
import com.juan.orangeTalents.controleusuarios.repository.UsuarioRepository;
import com.juan.orangeTalents.controleusuarios.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Optional<Usuario> getUsuarioById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario insertUsuario(UsuarioDto usuario) {
		Usuario u = usuario.toEntity();
		return usuarioRepository.save(u);
	}
}
