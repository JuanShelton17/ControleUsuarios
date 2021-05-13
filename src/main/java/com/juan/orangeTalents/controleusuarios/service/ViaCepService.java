package com.juan.orangeTalents.controleusuarios.service;

import com.juan.orangeTalents.controleusuarios.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "viacep.com.br/ws/", name = "viaCepService")
public interface ViaCepService {

    @GetMapping("{cep}/json")
    Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
