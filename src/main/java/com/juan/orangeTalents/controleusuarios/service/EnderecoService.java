package com.juan.orangeTalents.controleusuarios.service;

import java.util.List;
import java.util.Optional;

import com.juan.orangeTalents.controleusuarios.dto.EnderecoDto;
import com.juan.orangeTalents.controleusuarios.model.Endereco;

//@FeignClient(url = "viacep.com.br/ws/", name = "viacepService")
public interface EnderecoService {

	Optional<Endereco> getEnderecoById(Integer id);

	List<Endereco> getAllEnderecos();

	Endereco insertEndereco(EnderecoDto e);

//	List<Endereco> getUsuariosDeEnderecos();

//	@GetMapping("{cep}/json")
//    Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);
//
//	@RequestMapping(value = "/rest/insertEndereco", method = RequestMethod.POST)
//	void insertEndereco(Endereco endereco);
}