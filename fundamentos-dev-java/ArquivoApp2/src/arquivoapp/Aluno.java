package arquivoapp;

import java.io.Serializable;

public class Aluno implements Serializable{
    private String nome;
    private String telefone;
    
    public Aluno() {}
    
    public Aluno(String nome, String telefone) {
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

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", telefone=" + telefone + '}';
    }
}
