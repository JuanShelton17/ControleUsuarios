package com.juan.orangeTalents.controleusuarios.service;

import java.util.List;
import java.util.Optional;

import com.juan.orangeTalents.controleusuarios.dto.UsuarioDto;
import com.juan.orangeTalents.controleusuarios.model.Usuario;

public interface UsuarioService {

	Optional<Usuario> getUsuarioById(Integer id);

	List<Usuario> getAllUsuarios();

	Usuario insertUsuario(UsuarioDto usuario);

}
