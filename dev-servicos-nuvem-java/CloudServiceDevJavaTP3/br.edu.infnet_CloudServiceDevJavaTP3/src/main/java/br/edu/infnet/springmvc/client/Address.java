package br.edu.infnet.springmvc.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty
    private String logradouro;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String localidade;
    @JsonProperty
    private String uf;

    @Override
    public String toString() {
        return logradouro+", "+bairro+", "+localidade+" - "+uf;
    }
}
