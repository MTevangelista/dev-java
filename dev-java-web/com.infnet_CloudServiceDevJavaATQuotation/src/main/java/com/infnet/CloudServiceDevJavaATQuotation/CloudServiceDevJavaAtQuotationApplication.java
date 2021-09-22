package com.infnet.CloudServiceDevJavaATQuotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudServiceDevJavaAtQuotationApplication {

    public static void main(String[] args) {
            SpringApplication.run(CloudServiceDevJavaAtQuotationApplication.class, args);
    }

}
