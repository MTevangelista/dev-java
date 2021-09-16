/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.ExemploFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ericson
 */
@FeignClient(url="https://viacep.com.br/ws/", name="ViaCepClient")
public interface ViaCepService {
    @GetMapping("{cep}/json")
    Endereco buscaEnderecoPor(@PathVariable String cep);
}
