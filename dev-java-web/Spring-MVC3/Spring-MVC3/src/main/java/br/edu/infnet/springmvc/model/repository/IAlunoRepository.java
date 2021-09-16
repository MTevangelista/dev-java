package br.edu.infnet.springmvc.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.springmvc.model.negocio.Aluno;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface IAlunoRepository extends CrudRepository<Aluno, Integer> {

//  SQL
    @Query(value="SELECT * FROM alunos WHERE nome LIKE CONCAT('%', :keyword, '%') "
            + "OR telefone LIKE CONCAT('%', :keyword, '%')", nativeQuery=true)
    public List<Aluno> procurar(@Param("keyword") String keyword);
//  HQL   
//    @Query(value = "SELECT c FROM Aluno c WHERE c.nome LIKE '%' || :keyword || '%'"
//            + " OR c.telefone LIKE '%' || :keyword || '%'")    
//    public List<Aluno> procurar(@Param("keyword") String keyword);
}
