package com.juan.orangeTalents.controleUsuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.orangeTalents.controleUsuarios.dto.UsuarioDto;
import com.juan.orangeTalents.controleUsuarios.model.Usuario;
import com.juan.orangeTalents.controleUsuarios.repository.EnderecoRepository;
import com.juan.orangeTalents.controleUsuarios.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

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
		Usuario u = new Usuario();
		u = usuario.toEntity();

		return usuarioRepository.save(u);
	}
}
