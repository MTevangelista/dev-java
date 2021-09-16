/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.infnet.ExemploFeign;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ericson
 */
public class Empresa {
    @JsonProperty
    private String data_situacao;
    @JsonProperty
    private String complemento;
    @JsonProperty
    private String nome;
    
    @Override
    public String toString(){
        return "Empresa{" +
                "data_situacao='" + data_situacao + '\'' +
                ", complemento='" + complemento + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
