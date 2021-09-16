/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.ExemploFeign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ericson
 */
@RestController
public class CepController {
    private final ViaCepService vs;

    public CepController(ViaCepService vs) {
        this.vs = vs;
    }
    
    @GetMapping("viacep/{cep}")
    Endereco buscaEnderecoPor(@PathVariable String cep){
        return vs.buscaEnderecoPor(cep);
    }
    
}
