package br.edu.infnet.springboot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aluno {
    @JsonProperty
    private int id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String telefone;

    public Aluno() {}
    
    public Aluno(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Aluno(Integer id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    @Override
    public String toString() {
            return id + " " + nome + " " + telefone;
    }
}