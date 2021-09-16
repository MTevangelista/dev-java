package br.edu.infnet.APIClientTP1DR4;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {
        public User fetchInformations(String id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject("https://jsonplaceholder.typicode.com/users/{id}", User.class, id);
    }
}
