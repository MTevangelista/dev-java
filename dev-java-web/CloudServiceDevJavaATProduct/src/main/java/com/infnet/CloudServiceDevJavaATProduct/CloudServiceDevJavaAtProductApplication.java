package com.infnet.CloudServiceDevJavaATProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudServiceDevJavaAtProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceDevJavaAtProductApplication.class, args);
	}

}
