package br.edu.infnet.SpringMVCPU.AppController;

import org.springframework.beans.factory.annotation.Autowired;
import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.service.AlunoService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoRestAPI {
	
    @Autowired
    private AlunoService alunoService;
	
    @GetMapping("/alunos")
    public List<Aluno> consultarAlunos() {
        List<Aluno> alunos = alunoService.consultar();
        return alunos;
    }    
    
    @GetMapping("/aluno/{id}")
    public Aluno consultarAluno(@PathVariable Integer id) {
        Aluno aluno = alunoService.consultarPorID(id);
        return aluno;
    }

    @PostMapping("/incluir")
    public void incluir(@RequestBody Aluno aluno) {
        alunoService.salvar(aluno);
    }    
    
    @PutMapping("/alterar")
    public String alterar(@RequestBody Aluno aluno) {
        alunoService.salvar(aluno);
        return "Aluno alterado";
    }
    
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Integer id) {
        alunoService.excluir(id);
    }
    
    @GetMapping("/procurar/{keyword}")
    public List<Aluno> procurar(@PathVariable String keyword) {
        List<Aluno> result = alunoService.procurar(keyword);
        return result;
    }    
}