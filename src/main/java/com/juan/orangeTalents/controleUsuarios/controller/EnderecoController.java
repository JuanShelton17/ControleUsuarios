package com.juan.orangeTalents.controleUsuarios.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juan.orangeTalents.controleUsuarios.dto.EnderecoDto;
import com.juan.orangeTalents.controleUsuarios.model.Endereco;
import com.juan.orangeTalents.controleUsuarios.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping(value = "getAllEnderecos", method = RequestMethod.GET)
	public List<Endereco> getAll() {
		return enderecoService.getAllEnderecos();
	}

	@RequestMapping(value = "getEnderecos/{id}", method = RequestMethod.GET)
	public Optional<Endereco> getById(@PathVariable("id") Integer id) {
		return enderecoService.getEnderecoById(id);
	}

	@RequestMapping(value = "insertEnderecos", method = RequestMethod.POST)
	public ResponseEntity<Endereco> insert(@RequestBody @Valid EnderecoDto e) {
		Endereco insertEndereco = enderecoService.insertEndereco(e);
		return  new ResponseEntity<Endereco>(insertEndereco, HttpStatus.CREATED);
	}
	
//	@RequestMapping(value = "getUsuarios", method = RequestMethod.GET)
//	public ResponseEntity<List<Endereco>> getUsuarios() {
//		enderecoService.getUsuariosDeEnderecos();
//		return  new ResponseEntity<List<Endereco>>(HttpStatus.OK);
//	}
	

//	@RequestMapping(value = "/rest/insertEndereco", method = RequestMethod.POST)
//	public ResponseEntity<Endereco> buscarCep(@RequestBody Endereco endereco) {
//		var cep = endereco.getCep();
//		var request = enderecoService.buscaEnderecoPorCep(cep);
//		
//		endereco.setBairro(request.getBairro());
//		endereco.setComplemento(request.getComplemento());
//		endereco.setLogradouro(request.getLogradouro());
//		endereco.setUf(request.getUf());
//		
//		enderecoService.insertEndereco(endereco);
//		
//		return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
//	}
}
