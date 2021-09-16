/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.infnet.demo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.edu.infnet.demo.model.Customer;
import org.edu.infnet.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ericson
 */
@Service
@Transactional
public class CustomerService {
    
    private final CustomerRepository cr;
    
    public CustomerService(CustomerRepository cr) {
        this.cr = cr;
    }
    
    public Customer register(String firstName, String lastName, int addressId){  
        Calendar calendar = Calendar.getInstance();
        return this.cr.save(new Customer(firstName, lastName, false, calendar.getTime(), addressId, 1));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll(){
        return this.cr.findAll();
    }
    
}
