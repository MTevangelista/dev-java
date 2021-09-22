package com.infnet.CloudServiceDevJavaATProduct.repository;

import com.infnet.CloudServiceDevJavaATProduct.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {
    
    @Query(value="SELECT * FROM products WHERE code = :code", nativeQuery=true)
    public Product getByCode(@Param("code") int code);
    
}
