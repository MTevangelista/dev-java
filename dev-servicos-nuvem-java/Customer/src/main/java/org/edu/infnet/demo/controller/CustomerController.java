/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.infnet.demo.controller;

import java.util.List;
import org.edu.infnet.demo.model.Address;
import org.edu.infnet.demo.model.Customer;
import org.edu.infnet.demo.service.AddressService;
import org.edu.infnet.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ericson
 */
@RestController
public class CustomerController {
    private final CustomerService customerService;
    
    @Autowired
    private AddressService addressService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/customers")
    public List<Customer> all(){
        return customerService.findAll();
    }
        
    @PostMapping("/saveCustomer")
    public Customer register(@RequestPart(value = "firstname") String firstName, @RequestPart(value = "lastname") String lastName, @RequestPart(value = "address") String address){
        Address a = addressService.buscaEnderecoPor(address);
        return customerService.register(firstName, lastName, a.getAddressId());
    }
}
