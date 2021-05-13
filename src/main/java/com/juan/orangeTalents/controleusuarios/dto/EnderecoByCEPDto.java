package com.juan.orangeTalents.controleusuarios.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class EnderecoByCEPDto {


	@NotBlank
	private String cep;

	@NotBlank
	private String numero;

	@NotBlank
	private String complemento;

	@NotNull
	private UsuarioDto usuario;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
}
