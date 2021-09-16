package br.edu.infnet.springmvc.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.springmvc.model.negocio.Aluno;
import br.edu.infnet.springmvc.model.repository.IAlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private IAlunoRepository alunoRepository;

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> consultar() {
        return (List<Aluno>) alunoRepository.findAll();
    }

    public Aluno consultarPorID(Integer id) {
        return alunoRepository.findById(id).get();
    }

    public void excluir(Integer id) {
        alunoRepository.deleteById(id);
    }
    
    public List<Aluno> procurar(String keyword) {
        return alunoRepository.procurar(keyword);
    }
}