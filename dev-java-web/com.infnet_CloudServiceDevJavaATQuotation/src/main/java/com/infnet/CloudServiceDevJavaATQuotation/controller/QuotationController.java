package com.infnet.CloudServiceDevJavaATQuotation.controller;

import com.infnet.CloudServiceDevJavaATQuotation.client.ProductClientModel;
import com.infnet.CloudServiceDevJavaATQuotation.client.ProductClient;
import com.infnet.CloudServiceDevJavaATQuotation.model.Product;
import com.infnet.CloudServiceDevJavaATQuotation.model.Quotation;
import com.infnet.CloudServiceDevJavaATQuotation.service.QuotationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotationController {
    
    @Autowired
    private QuotationService quotationService;
    
    @Autowired
    private ProductClient productClient;
    
    @RequestMapping(value = "/register-quotation", method = RequestMethod.POST)
    public String registerQuotation(
            @RequestParam double price,
            @RequestParam int identifier,
            @RequestParam int id
    ) {
        Quotation quotation;
        Product product;
        //ProductClientModel productClientModel;
        
        try {
            product = productClient.getById(id);
        } catch (Exception error) {
            return "Product not found: "+error;
        }
//        product = new Product(
//                productClientModel.getId(),
//                productClientModel.getImg(),
//                productClientModel.getName(),
//                productClientModel.getQuantity(),
//                productClientModel.getCode()
//        );
        quotation = quotationService.getByIdentifier(identifier);
        if (quotation != null) {
           return "Quotation Already exists";
        }
        quotation = new Quotation(price, identifier, product);
        try {
            quotationService.save(quotation);
        } catch (Exception error) {
           return "Unexpected error while creating a quotation: "+error;
        }
        return "Quotation created with success";
    }
    
//    @RequestMapping(value = "/products", method = RequestMethod.GET)
//    public List<Quotation> getAllProducts() {
//        return productService.getAll();
//    }
//    
//    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
//    public String getProductById(@PathVariable Integer id) {
//        Quotation product;
//        
//        try {
//            product = productService.getById(id);
//        } catch (Exception e) {
//            return "Product not found";
//        }
//        return "Response: "+product;
//    }
    
//    @RequestMapping(value = "/update-product/{id}", method = RequestMethod.PUT)
//    public String updateProduct(
//            @PathVariable Integer id,
//            @RequestBody Product productRequest
//    ) {
//        Quotation product;
//        
//        try {
//            product = productService.getById(id);
//        } catch (Exception e) {
//            return "Product not found";
//        }
//        product.setImg(productRequest.getImg());
//        product.setName(productRequest.getName());
//        product.setQuantity(productRequest.getQuantity());
//        product.setQuotations(product.getQuotations());
//        try {
//            productService.save(product);
//        } catch (Exception error) {
//            return "Unexpected error while editing a product: "+error;
//        }
//        return "Product updated with success";
//    }
    
//    @RequestMapping(value = "/delete-product/{id}", method = RequestMethod.DELETE)
//    public String deleteProduct(@PathVariable Integer id) {
//        Quotation quotation;
//        
//        try {
//            quotation = productService.getById(id);
//        } catch (Exception e) {
//            return "Product not found";
//        }
//        try {
//            productService.delete(id);
//        } catch (Exception error) {
//            return "Unexpected error while deleting a product: "+error;
//        }
//        return "Product deleted with success";
//    }
}
