package org.edu.infnet.demo.controller;

import java.util.List;
import org.edu.infnet.demo.model.Product;
import org.edu.infnet.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
//    @Autowired
//    private AddressService addressService;
    
    @Autowired
    private ProductService productService;
    
    @PostMapping("/register-product")
    public void register(
            @RequestPart(value = "name") String name,
            @RequestPart(value = "quantity") int quantity,
            @RequestPart(value = "code") int code
    ) {
        Product product;
        
        product = productService.getByCode(code);
        if (product == null) {
            productService.register(new Product(name, quantity, code));
        }
    }

//    @GetMapping("/customers")
//    public List<Customer> all(){
//        return customerService.findAll();
//    }
        
//    @PostMapping("/saveCustomer")
//    public Customer register(@RequestPart(value = "name") String firstName, @RequestPart(value = "lastname") String lastName, @RequestPart(value = "address") String address){
//        Address a = addressService.buscaEnderecoPor(address);
//        return customerService.register(firstName, lastName, a.getAddressId());
//    }
    
}
