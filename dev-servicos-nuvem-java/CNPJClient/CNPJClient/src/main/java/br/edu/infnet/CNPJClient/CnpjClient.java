/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.CNPJClient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ericson
 */
@Component
public class CnpjClient {
    public Empresa buscaEmpresaPor(String cnpj){
        RestTemplate template = new RestTemplate();
        return template.getForObject("https://www.receitaws.com.br/v1/cnpj/{cnpj}",Empresa.class, cnpj);
    }
    
}
