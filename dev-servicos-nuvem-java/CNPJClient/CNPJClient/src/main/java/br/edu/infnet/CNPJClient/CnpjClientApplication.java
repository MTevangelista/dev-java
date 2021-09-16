package br.edu.infnet.CNPJClient;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CnpjClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnpjClientApplication.class, args);
	}
        
        @Bean
        public CommandLineRunner run(CnpjClient client){
            return args -> {
                
                System.out.println("cnpj");
                Scanner s = new Scanner(System.in);
                String cnpj = s.nextLine();
                Empresa empresa = client.buscaEmpresaPor(cnpj);
                System.out.println(empresa);
                
            };
        }

}
