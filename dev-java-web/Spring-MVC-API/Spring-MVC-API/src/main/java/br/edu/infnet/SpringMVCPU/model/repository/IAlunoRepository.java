package br.edu.infnet.SpringMVCPU.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface IAlunoRepository extends CrudRepository<Aluno, Integer> {

    @Query(value = "SELECT c FROM Aluno c WHERE c.nome LIKE '%' || :keyword || '%'"
            + " OR c.telefone LIKE '%' || :keyword || '%'")
    public List<Aluno> search(@Param("keyword") String keyword);    
}
