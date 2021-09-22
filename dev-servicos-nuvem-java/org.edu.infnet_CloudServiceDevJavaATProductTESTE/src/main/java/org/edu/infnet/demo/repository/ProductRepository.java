package org.edu.infnet.demo.repository;

import org.edu.infnet.demo.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
    @Query(value="SELECT * FROM products WHERE code = :code", nativeQuery=true)
    public Product getByCode(@Param("code") int code);
    
}
