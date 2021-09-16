package br.edu.infnet.springmvc.model.negocio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="alunos")
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private int id;
    private String nome;
    private String telefone;

    public Aluno() {}
    
    public Aluno(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Email> emails = new HashSet<>();
    
    public Set<Email> getEmails() {
        return emails;
    }
    
    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "alunos_disciplinas", joinColumns = { @JoinColumn(name = "id_aluno") },
            inverseJoinColumns = { @JoinColumn(name = "id_disciplina") })
    
    Set<Disciplina> disciplinas = new HashSet<>();
    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id + " " + nome + " " + telefone;
    }  
}