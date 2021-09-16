package br.edu.infnet.springboot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ClienteRest {
    
    @Autowired
    IClienteAPI clienteAPI;
    
    @GetMapping("/alunos")
    public List<Aluno> consultaAlunos() {
        return clienteAPI.consultaAlunos();
    }
    
    @GetMapping("/aluno/{id}")
    public Aluno consultaAluno(@PathVariable Integer id) {
        return clienteAPI.consultaAluno(id);
    }    
    
    @GetMapping("/incluir/{nome}/{telefone}")
    public void incluir(@PathVariable String nome, @PathVariable String telefone) {
        clienteAPI.salvar(new Aluno(nome, telefone));
    }
    
    @GetMapping("/alterar/{id}/{nome}/{telefone}")
    public void incluir(@PathVariable Integer id, @PathVariable String nome, @PathVariable String telefone) {
        clienteAPI.salvar(new Aluno(id, nome, telefone));
    }
    
    @GetMapping("/excluir/{id}")
    public void excluir(@PathVariable Integer id) {
        clienteAPI.excluir(id);    
    }
    
    @GetMapping("/procurar/{keyword}")
    public List<Aluno> procurar(@PathVariable String keyword) {
        return clienteAPI.procurar(keyword);        
    }
}