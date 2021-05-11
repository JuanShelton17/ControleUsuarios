package com.juan.orangeTalents.controleusuarios.repository;

import com.juan.orangeTalents.controleusuarios.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}


