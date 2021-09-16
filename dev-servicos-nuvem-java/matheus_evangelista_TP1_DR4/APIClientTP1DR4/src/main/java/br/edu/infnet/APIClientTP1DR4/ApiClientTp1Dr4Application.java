package br.edu.infnet.APIClientTP1DR4;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiClientTp1Dr4Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiClientTp1Dr4Application.class, args);
    }
    
    @Bean
    public CommandLineRunner run(UserClient client){
        return args -> {
            Scanner s = new Scanner(System.in);
            System.out.println("Entre com Id: ");
            String userId = s.nextLine();
            System.out.println("userId = "+ userId);
            User user = client.fetchInformations(userId);
            System.out.println(user);
         };
    }


}
