package com.infnet.CloudServiceDevJavaATProduct.controller;

import com.infnet.CloudServiceDevJavaATProduct.model.Product;
import com.infnet.CloudServiceDevJavaATProduct.model.Quotation;
import com.infnet.CloudServiceDevJavaATProduct.service.ProductService;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "/register-product", method = RequestMethod.POST)
    public String registerProduct(
            @RequestPart MultipartFile img,
            @RequestParam String name,
            @RequestParam int quantity,
            @RequestParam int code
    ) throws IOException {
        Product product;
        String imgURL;
        
        product = productService.getByCode(code);
        if (product != null) {
           return "Product Already exists";
        }
        imgURL = productService.prepareImgURL(img);
        product = new Product(imgURL, name, quantity, code);
        try {
            productService.save(product);
        } catch (Exception error) {
           return "Unexpected error while creating a product: "+error;
        }
        return "Product created with success";
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAll();
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getProductById(@RequestParam int id) {
        Product product;
        
        try {
            product = productService.getById(id);
        } catch (Exception e) {
            return "Product not found";
        }
        return "Response: "+product;
    }
    
    @RequestMapping(value = "/update-product/{id}", method = RequestMethod.PUT)
    public String updateProduct(
            @PathVariable Integer id,
            @RequestPart MultipartFile img,
            @RequestParam String name,
            @RequestParam int quantity
//            @RequestParam int code,
//            @RequestParam Set<Quotation> quotations
    ) throws IOException {
        Product product;
        String imgURL;
        
        try {
            product = productService.getById(id);
        } catch (Exception e) {
            return "Product not found";
        }
        imgURL = productService.prepareImgURL(img);
        product.setImg(imgURL);
        product.setName(name);
        product.setQuantity(quantity);
//        product.setQuotations(quotations);
        try {
            productService.save(product);
        } catch (Exception error) {
            return "Unexpected error while editing a product: "+error;
        }
        return "Product updated with success";
    }
    
    @RequestMapping(value = "/delete-product/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable Integer id) {
        Product product;
        
        try {
            product = productService.getById(id);
        } catch (Exception e) {
            return "Product not found";
        }
        try {
            productService.delete(id);
        } catch (Exception error) {
            return "Unexpected error while deleting a product: "+error;
        }
        return "Product deleted with success";
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
