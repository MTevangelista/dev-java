package br.edu.infnet.springmvc.model.repository;

import br.edu.infnet.springmvc.model.negocio.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends CrudRepository<Endereco, Integer> {
    
}
