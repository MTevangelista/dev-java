package com.example.infnet.matheusevangelista.Aula100821;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula100821Application {

    public static void main(String[] args) {
            SpringApplication.run(Aula100821Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ViaCEPClient client) {
        return args -> {
            if (args.length > 0) {
                String cep = args[0];
                System.out.println("cep = "+ cep);
                Endereco endereco = client.buscaEnderecoPor(cep);
                System.out.println(endereco);
            }
        };
    }
}
