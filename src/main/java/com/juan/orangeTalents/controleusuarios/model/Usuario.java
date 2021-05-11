package com.juan.orangeTalents.controleusuarios.model;

import com.juan.orangeTalents.controleusuarios.dto.UsuarioDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String cpf;
	
	private String nome;

	private String email;

	private String dataNascimento;

	@OneToMany(mappedBy = "usuario")
	private List<Endereco> endereco = new ArrayList<>();
	
	public Usuario(int id, String cpf, String name, String email, String dataNascimento, List<Endereco> endereco) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = name;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}
	
	public UsuarioDto toDto() {
		UsuarioDto usuarioDto =  new UsuarioDto();
		usuarioDto.setCpf(this.cpf);
		usuarioDto.setDataNascimento(this.dataNascimento);
		usuarioDto.setEmail(this.email);
		usuarioDto.setId(this.id);
		usuarioDto.setNome(this.nome);
		usuarioDto.setEndereco(this.endereco.stream().map(Endereco::toDto).collect(Collectors.toList()));
		return usuarioDto;
	}

	public Usuario() {
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


	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
}
