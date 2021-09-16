/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.infnet.Address.controller;

import java.util.List;
import org.edu.infnet.Address.model.Address;
import org.edu.infnet.Address.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ericson
 */
@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    
    @GetMapping("/address")
    public List<Address> all(){
        return addressService.findAll();
    }
    
    @RequestMapping(method = {RequestMethod.GET}, value = "/address/{address}") 
    public Address findByAddress(@PathVariable String address){
        return addressService.findByAddress(address);
    }
}
