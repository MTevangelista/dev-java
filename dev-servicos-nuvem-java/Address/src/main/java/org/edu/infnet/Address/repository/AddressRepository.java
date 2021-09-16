/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.infnet.Address.repository;

import org.edu.infnet.Address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ericson
 */
public interface AddressRepository extends JpaRepository<Address, Short>{
    public Address findByAddress(String address);
}
