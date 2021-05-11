package com.juan.orangeTalents.controleusuarios.dto;

import com.juan.orangeTalents.controleusuarios.model.Usuario;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class UsuarioDto implements Serializable {

	private int id;

	@NotBlank
	private String cpf;

	@NotBlank
	private String nome;

	@NotBlank
	private String email;

	@NotBlank
	private String dataNascimento;

	private List<EnderecoUsuarioDto> endereco;

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

	public List<EnderecoUsuarioDto> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoUsuarioDto> endereco) {
		this.endereco = endereco;
	}
}
