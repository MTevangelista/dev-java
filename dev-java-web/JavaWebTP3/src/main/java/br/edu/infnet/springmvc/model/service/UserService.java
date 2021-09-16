package br.edu.infnet.springmvc.model.service;

import br.edu.infnet.springmvc.models.User;
import br.edu.infnet.springmvc.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private IUserRepository repository;
    
    public void signUp(User user) {
        repository.save(user);
    }
    
    public User validate(String email, String password) {
        return repository.getByEmail(email);
    }
    
//    public boolean validate(String email, String password) {
//        boolean userAlreadyExists = false;
//        User user = repository.getByEmail(email);
//        
//        if (user != null) {
//            if (password.equals(user.getPassword())) {
//                userAlreadyExists = true;
//            }
//        }
//        return userAlreadyExists;
//    }
    
}
