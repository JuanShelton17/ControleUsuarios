package com.juan.orangeTalents.controleusuarios.service.impl;

import com.juan.orangeTalents.controleusuarios.dto.UsuarioDto;
import com.juan.orangeTalents.controleusuarios.exception.CpfExistenteException;
import com.juan.orangeTalents.controleusuarios.exception.EmailExixtenteException;
import com.juan.orangeTalents.controleusuarios.exception.ErroAcessoBDException;
import com.juan.orangeTalents.controleusuarios.exception.UsuarioNaoEncontradoException;
import com.juan.orangeTalents.controleusuarios.model.Usuario;
import com.juan.orangeTalents.controleusuarios.repository.UsuarioRepository;
import com.juan.orangeTalents.controleusuarios.service.UsuarioService;
import org.springframework.dao.DataIntegrityViolationException;
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
	public Optional<Usuario> getUsuarioById(Integer id) throws UsuarioNaoEncontradoException{
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (!usuario.isPresent()) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado");
		}
		return usuario;
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario insertUsuario(UsuarioDto usuarioDto) {
		try {
			Usuario usuario = usuarioRepository.save(usuarioDto.toEntity());
			return usuario;
		} catch (DataIntegrityViolationException exe) {
			if (exe.getMessage().toString().contains("USUARIO(CPF)")) {
				throw new CpfExistenteException("CPF existente");
			} else {
				throw new EmailExixtenteException("E-mail existente");
			}
		} catch (Exception e) {
			throw new ErroAcessoBDException(e.getMessage());
		}
	}
}
