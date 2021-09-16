package br.edu.infnet.springmvc.model.repository;

import br.edu.infnet.springmvc.model.negocio.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmailRepository extends CrudRepository<Email, Integer>{
    
}
