package com.juan.orangeTalents.controleUsuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.orangeTalents.controleUsuarios.dto.EnderecoDto;
import com.juan.orangeTalents.controleUsuarios.model.Endereco;
import com.juan.orangeTalents.controleUsuarios.repository.EnderecoRepository;

@Service("enderecoService")
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Optional<Endereco> getEnderecoById(Integer id) {
		return enderecoRepository.findById(id);
	}

	@Override
	public List<Endereco> getAllEnderecos() {
		return enderecoRepository.findAll();
	}

	@Override
	public Endereco insertEndereco(EnderecoDto e) {
		Endereco endereco = new Endereco();
		endereco = e.toEntity();
		return enderecoRepository.save(endereco);
	}

//	@Override
//	public List<Endereco> getUsuariosDeEnderecos() {
//		return enderecoRepository.getUsuariosDeEnderecos();
//	}

//	@Override
//	public Endereco buscaEnderecoPorCep(String cep) {
//		return null;
//	}

//	@Override
//	public void insertEndereco(Endereco endereco) {
//		enderecoRepository.save(endereco);
//	}
}
