package com.infnet.CloudServiceDevJavaATQuotation.repository;

import com.infnet.CloudServiceDevJavaATQuotation.model.Quotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuotationRepository extends CrudRepository<Quotation, Integer> {
    
    @Query(value="SELECT * FROM quotations WHERE identifier = :identifier", nativeQuery=true)
    public Quotation getByIdentifier(@Param("identifier") int identifier);
    
}
