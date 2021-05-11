	package com.juan.orangeTalents.controleUsuarios.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.juan.orangeTalents.controleUsuarios.dto.EnderecoDto;


@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cep;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;

	private String localidade;

	private String uf;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario; 

	public Endereco(int id, String cep, String logradouro, String numero, String complemento, String bairro,
			String localidade, String uf) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}
	
	public EnderecoDto toDto() {
		
		EnderecoDto enderecoDto =  new EnderecoDto();
		
		
		enderecoDto.setId(this.id);
		enderecoDto.setCep(this.cep);
		enderecoDto.setBairro(this.bairro);
		enderecoDto.setComplemento(this.complemento);
		enderecoDto.setLocalidade(this.localidade);
		enderecoDto.setLogradouro(this.logradouro);
		enderecoDto.setUf(this.uf);
		enderecoDto.setNumero(this.numero);
//		enderecoDto.setUsuario(this.usuario.toDto());
		
		
		return enderecoDto;
	}

	public Endereco() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
