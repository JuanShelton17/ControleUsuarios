package com.juan.orangeTalents.controleusuarios.controller;

import com.juan.orangeTalents.controleusuarios.dto.EnderecoByCEPDto;
import com.juan.orangeTalents.controleusuarios.dto.EnderecoDto;
import com.juan.orangeTalents.controleusuarios.dto.EnderecoUsuarioDto;
import com.juan.orangeTalents.controleusuarios.model.Endereco;
import com.juan.orangeTalents.controleusuarios.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public ResponseEntity<EnderecoUsuarioDto> getById(@PathVariable("id") Integer id) {
		Optional<Endereco> endereco = enderecoService.getEnderecoById(id);
		if (!endereco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(endereco.get().toDto());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<EnderecoUsuarioDto> insert(@RequestBody @Valid EnderecoDto e) {
		Endereco endereco = enderecoService.insertEndereco(e);
		return  ResponseEntity.created(URI.create(String.format("/enderecos/%s", endereco.getId()))).body(endereco.toDto());
	}

	@RequestMapping(value = "/cep", method = RequestMethod.POST)
	public ResponseEntity<EnderecoUsuarioDto> insertByCEP(@RequestBody @Valid EnderecoByCEPDto e) {
		Endereco endereco = enderecoService.insertEnderecoByCep(e);
		return  ResponseEntity.created(URI.create(String.format("/enderecos/%s", endereco.getId()))).body(endereco.toDto());
	}

}
