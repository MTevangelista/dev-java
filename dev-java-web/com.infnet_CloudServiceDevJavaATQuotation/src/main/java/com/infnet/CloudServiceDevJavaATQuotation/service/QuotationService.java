package com.infnet.CloudServiceDevJavaATQuotation.service;

import com.infnet.CloudServiceDevJavaATQuotation.model.Quotation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infnet.CloudServiceDevJavaATQuotation.repository.IQuotationRepository;

@Service
public class QuotationService {
    
    @Autowired
    IQuotationRepository repository;
    
    public Quotation save(Quotation quotation) {  
        return repository.save(quotation);
    }

    public List<Quotation> getAll(){
        return (List<Quotation>) repository.findAll();
    }
    
    public Quotation getById(int id) {
        return repository.findById(id).get();
    }
    
    public Quotation getByIdentifier(int code) {
        return repository.getByIdentifier(code);
    }
    
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
}

