/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.ExemploFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ericson
 */
@FeignClient(url="https://www.receitaws.com.br/v1/cnpj/", name="CnpjClient")
public interface CNPJService {
    @GetMapping("{cnpj}")
    Empresa buscaEmpresaPor(@PathVariable String cnpj);
}
