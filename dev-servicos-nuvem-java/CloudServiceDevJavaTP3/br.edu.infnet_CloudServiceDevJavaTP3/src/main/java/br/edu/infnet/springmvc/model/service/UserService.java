package br.edu.infnet.springmvc.model.service;

import br.edu.infnet.springmvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.springmvc.repository.IUserRepository;

@Service
public class UserService {
    
    @Autowired
    private IUserRepository repository;

    public void save(User user) {
        repository.save(user);
    }
    
    public User getById(int id) {
        return repository.findById(id).get();
    }
    
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }
    
}
