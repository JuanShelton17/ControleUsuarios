package com.juan.orangeTalents.controleusuarios.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juan.orangeTalents.controleusuarios.dto.EnderecoByCEPDto;
import com.juan.orangeTalents.controleusuarios.dto.EnderecoDto;
import com.juan.orangeTalents.controleusuarios.dto.EnderecoUsuarioDto;
import com.juan.orangeTalents.controleusuarios.exception.EnderecoNaoEncontradoException;
import com.juan.orangeTalents.controleusuarios.model.Endereco;
import com.juan.orangeTalents.controleusuarios.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	private final EnderecoService enderecoService;

	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EnderecoUsuarioDto>> getAll() {
		List<Endereco> enderecos = enderecoService.getAllEnderecos();
		return ResponseEntity.ok(enderecos.stream().map(Endereco::toDto).collect(Collectors.toList()));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getById(@PathVariable("id") Integer id) {
		try 
		{
			Optional<Endereco> endereco = enderecoService.getEnderecoById(id);
			return ResponseEntity.ok(endereco.get().toDto());
		} catch (EnderecoNaoEncontradoException ex) 
		{
			return ResponseEntity.status(404).body(ex.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody @Valid EnderecoDto e) {
		try 
		{
			Endereco endereco = enderecoService.insertEndereco(e);
			return ResponseEntity.created(URI.create(String.format("/enderecos/%s", endereco.getId())))
					.body(endereco.toDto());
		} catch (Exception ex) 
		{
			return ResponseEntity.status(400).body(ex.getMessage());
		}
	}

	@RequestMapping(value = "/cep", method = RequestMethod.POST)
	public ResponseEntity<?> insertByCEP(@RequestBody @Valid EnderecoByCEPDto e) {
		try {
			Endereco endereco = enderecoService.insertEnderecoByCep(e);
			return ResponseEntity.created(URI.create(String.format("/enderecos/%s", endereco.getId())))
					.body(endereco.toDto());
			
		} catch (Exception ex) {
			return ResponseEntity.status(400).body(ex.getMessage());
		}
	}

}
