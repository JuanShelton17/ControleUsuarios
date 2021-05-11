package com.juan.orangeTalents.controleUsuarios.dto;

import javax.validation.constraints.NotBlank;

import com.juan.orangeTalents.controleUsuarios.model.Usuario;

public class UsuarioEnderecoDto {

	private int id;
	
	@NotBlank
	private String cpf;

	@NotBlank
	private String nome;

	@NotBlank
	private String email;

	@NotBlank
	private String dataNascimento;

	public Usuario toEntity() {
		Usuario usuario = new Usuario();
		
		usuario.setCpf(this.cpf);
		usuario.setDataNascimento(this.dataNascimento);
		usuario.setEmail(this.email);
		usuario.setId(this.id);
		usuario.setNome(this.nome);

		return usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
