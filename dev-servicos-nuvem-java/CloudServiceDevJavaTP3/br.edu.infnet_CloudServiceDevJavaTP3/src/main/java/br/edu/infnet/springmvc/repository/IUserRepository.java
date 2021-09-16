package br.edu.infnet.springmvc.repository;

import br.edu.infnet.springmvc.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer>  {
    
    @Query(value="SELECT email, cpf FROM users WHERE email = :email AND cpf = :cpf", nativeQuery=true)
    public User checkIfUserAlreadyExists(@Param("email") String email, @Param("cpf") String cpf);
    
    @Query(value="SELECT * FROM users WHERE email = :email", nativeQuery=true)
    public User getByEmail(@Param("email") String email);
    
    
}
