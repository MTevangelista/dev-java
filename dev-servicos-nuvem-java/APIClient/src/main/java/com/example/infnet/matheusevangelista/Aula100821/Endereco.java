package com.example.infnet.matheusevangelista.Aula100821;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Endereco {
    @JsonProperty
    private String cep;
    @JsonProperty
    private String logradouro;
    @JsonProperty
    private String complemento;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String localidade;
    @JsonProperty
    private String uf;
    @JsonProperty
    private String ibge;
    @JsonProperty
    private String ddd;
    @JsonProperty
    private String siafi;
    @JsonProperty
    private boolean erro = false;
    
    @Override
    public String toString() {
        if (!erro) {
            return "Endereco {" +
                    "cep='" + cep + '\'' +
                    ", logradouro='" + logradouro + '\'' +
                    ", complemento='" + complemento + '\'' +
                    ", bairro='" + bairro + '\'' +
                    ", localidade='" + localidade + '\'' +
                    ", uf='" + uf + '\'' +
                    ", ibge='" + ibge + '\'' +
                    ", ddd='" + ddd + '\'' +
                    ", siafi='" + siafi + '\'' +
                    '}';
        } else {
            return "Endereço inexistente";
        }
    }
}
