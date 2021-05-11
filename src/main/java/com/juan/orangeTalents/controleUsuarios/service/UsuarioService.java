package com.juan.orangeTalents.controleUsuarios.service;

import java.util.List;
import java.util.Optional;

import com.juan.orangeTalents.controleUsuarios.dto.UsuarioDto;
import com.juan.orangeTalents.controleUsuarios.model.Usuario;

public interface UsuarioService {

	Optional<Usuario> getUsuarioById(Integer id);

	List<Usuario> getAllUsuarios();

	Usuario insertUsuario(UsuarioDto usuario);

}
