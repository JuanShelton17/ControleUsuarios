package com.juan.orangeTalents.controleusuarios.service.impl;

import com.juan.orangeTalents.controleusuarios.dto.EnderecoByCEPDto;
import com.juan.orangeTalents.controleusuarios.dto.EnderecoDto;
import com.juan.orangeTalents.controleusuarios.model.Endereco;
import com.juan.orangeTalents.controleusuarios.repository.EnderecoRepository;
import com.juan.orangeTalents.controleusuarios.service.EnderecoService;
import com.juan.orangeTalents.controleusuarios.service.ViaCepService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	private final EnderecoRepository enderecoRepository;
	private final ViaCepService viaCepService;

	public EnderecoServiceImpl(EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
		this.enderecoRepository = enderecoRepository;
		this.viaCepService = viaCepService;
	}

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
		Endereco endereco = e.toEntity();
		return enderecoRepository.save(endereco);
	}

	@Override
	public Endereco insertEnderecoByCep(EnderecoByCEPDto e) {
		Endereco endereco = viaCepService.buscaEnderecoPorCep(e.getCep());
		endereco.setNumero(e.getNumero());
		endereco.setComplemento(e.getComplemento());
		endereco.setUsuario(e.getUsuario().toEntity());
		return enderecoRepository.save(endereco);
	}

}
