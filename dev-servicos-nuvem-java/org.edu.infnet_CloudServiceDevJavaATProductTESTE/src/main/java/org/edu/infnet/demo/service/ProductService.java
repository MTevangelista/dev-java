package org.edu.infnet.demo.service;

import java.util.List;
import org.edu.infnet.demo.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.edu.infnet.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    ProductRepository repository;
    
    public Product register(Product product) {  
        return repository.save(product);
    }
    
    public List<Product> getAll(){
        return (List<Product>) repository.findAll();
    }
    
    public Product getById(int id) {
        return repository.findById(id).get();
    }
    
    public Product getByCode(int code) {
        return repository.getByCode(code);
    }
    
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
}
