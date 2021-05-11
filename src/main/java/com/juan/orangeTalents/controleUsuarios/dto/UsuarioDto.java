package com.juan.orangeTalents.controleUsuarios.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.juan.orangeTalents.controleUsuarios.model.Usuario;

public class UsuarioDto {

	private int id;
	
	@NotBlank
	private String cpf;

	@NotBlank
	private String nome;

	@NotBlank
	private String email;

	@NotBlank
	private String dataNascimento;

	private List<EnderecoDto> endereco;

	public Usuario toEntity() {
		Usuario usuario = new Usuario();
		
		usuario.setCpf(this.cpf);
		usuario.setDataNascimento(this.dataNascimento);
		usuario.setEmail(this.email);
		usuario.setId(this.id);
		usuario.setNome(this.nome);
		if(this.endereco != null) 
		{
			usuario.setEndereco(this.endereco.stream().map(EnderecoDto::toEntity).collect(Collectors.toList()));
		}
		

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

	public List<EnderecoDto> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoDto> endereco) {
		this.endereco = endereco;
	}
}
