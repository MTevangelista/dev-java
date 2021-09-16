/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.infnet.demo.repository;

import org.edu.infnet.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ericson
 */
public interface CustomerRepository extends JpaRepository<Customer, Short>{
    
}
