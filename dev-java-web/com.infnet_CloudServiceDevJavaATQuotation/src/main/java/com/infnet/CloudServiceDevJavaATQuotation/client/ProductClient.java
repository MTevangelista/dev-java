package com.infnet.CloudServiceDevJavaATQuotation.client;

import com.infnet.CloudServiceDevJavaATQuotation.model.Product;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url="http://localhost:8080", name = "ProductClient")
@Headers("Content-Type: application/json")
public interface ProductClient {
    
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    Product getById(@RequestParam int id);
    
}