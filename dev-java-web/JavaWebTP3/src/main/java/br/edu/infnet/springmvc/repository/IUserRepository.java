package br.edu.infnet.springmvc.repository;

import br.edu.infnet.springmvc.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
    
    @Query(value="SELECT * FROM users WHERE email = :email", nativeQuery=true)
    public User getByEmail(@Param("email") String email);
    
//    @Query(value="SELECT email, password FROM users WHERE email = :email AND password = :password", nativeQuery=true)
//    public User find(@Param("email") String email, @Param("password") String password);
    
}
