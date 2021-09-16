/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.infnet.Address.service;

import java.util.List;
import org.edu.infnet.Address.model.Address;
import org.edu.infnet.Address.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ericson
 */
@Service
@Transactional
public class AddressService {
    private final AddressRepository ar;
    
    public AddressService(AddressRepository ar) {
        this.ar = ar;
    }
    
    @Transactional(readOnly = true)
    public List<Address> findAll(){
        return this.ar.findAll();
    }    
    
    @Transactional(readOnly = true)
    public Address findByAddress(String address){
        return this.ar.findByAddress(address);
    }
}
