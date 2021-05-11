package com.juan.orangeTalents.controleUsuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juan.orangeTalents.controleUsuarios.model.Endereco;

@Repository("enderecoRepository")
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
//	@Query("Select e from endereco e Join e.usuario u")
//	List<Endereco> getUsuariosDeEnderecos();
}


