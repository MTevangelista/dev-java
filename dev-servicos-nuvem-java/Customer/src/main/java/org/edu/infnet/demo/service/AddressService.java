package org.edu.infnet.demo.service;

import org.edu.infnet.demo.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8081/address/", name = "AddressService")
public interface AddressService {
    
    @GetMapping("{address}")
    Address buscaEnderecoPor(@PathVariable("address") String address);
}