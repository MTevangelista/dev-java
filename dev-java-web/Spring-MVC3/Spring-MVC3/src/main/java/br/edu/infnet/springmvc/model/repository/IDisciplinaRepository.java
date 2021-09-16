package br.edu.infnet.springmvc.model.repository;

import br.edu.infnet.springmvc.model.negocio.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDisciplinaRepository extends CrudRepository<Disciplina, Integer>{
    
}