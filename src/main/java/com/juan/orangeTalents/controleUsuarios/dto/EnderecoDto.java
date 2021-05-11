package com.juan.orangeTalents.controleUsuarios.dto;


import javax.validation.constraints.NotBlank;

import com.juan.orangeTalents.controleUsuarios.model.Endereco;
import com.sun.istack.NotNull;

public class EnderecoDto {

	private int id;

	@NotBlank
	private String cep;

	@NotBlank
	private String logradouro;

	@NotBlank
	private String numero;

	@NotBlank
	private String complemento;

	@NotBlank
	private String bairro;

	@NotBlank
	private String localidade;

	@NotBlank
	private String uf;

	@NotNull
	private UsuarioEnderecoDto usuario;

	public Endereco toEntity() {

		Endereco endereco = new Endereco();

		endereco.setCep(this.cep);
		endereco.setBairro(this.bairro);
		endereco.setComplemento(this.complemento);
		endereco.setId(this.id);
		endereco.setLocalidade(this.localidade);
		endereco.setLogradouro(this.logradouro);
		endereco.setUf(this.uf);
		endereco.setNumero(this.numero);
		endereco.setUsuario(this.usuario.toEntity());

		return endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public UsuarioEnderecoDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEnderecoDto usuario) {
		this.usuario = usuario;
	}
}
