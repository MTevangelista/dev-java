package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication{

        //Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
        public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
        
        @Bean
        public CommandLineRunner run(ViaCEPClient client){
            return args -> {
                if (args.length > 0) {
                    String cep = args[0];
                    System.out.println("cep = "+ cep);
                    // Implementar validação do formato do CEP
                    Endereco endereco = client.buscaEnderecoPor(cep);
                    
                    System.out.println(endereco);
                }
            };
        }
}
