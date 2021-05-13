package com.juan.orangeTalents.controleusuarios.service;

import com.juan.orangeTalents.controleusuarios.dto.EnderecoByCEPDto;
import com.juan.orangeTalents.controleusuarios.dto.EnderecoDto;
import com.juan.orangeTalents.controleusuarios.model.Endereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

	Optional<Endereco> getEnderecoById(Integer id);

	List<Endereco> getAllEnderecos();

	Endereco insertEndereco(EnderecoDto e);

	Endereco insertEnderecoByCep(EnderecoByCEPDto e);

}