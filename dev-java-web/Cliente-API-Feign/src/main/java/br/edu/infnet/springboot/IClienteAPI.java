package br.edu.infnet.springboot;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "alunos", url = "http://localhost:8080/")
public interface IClienteAPI {
    
    @GetMapping("/alunos")
    List<Aluno> consultaAlunos();    
    
    @GetMapping("/aluno/{id}")
    Aluno consultaAluno(@PathVariable Integer id);
    
    @PostMapping("/incluir")
    void salvar(Aluno aluno);

    @PutMapping("/alterar")
    void alterar(Aluno aluno);

    @DeleteMapping("/excluir/{id}")
    void excluir(@PathVariable Integer id);
    
    @GetMapping("/procurar/{keyword}")
    List<Aluno> procurar(@PathVariable String keyword);    
}   
