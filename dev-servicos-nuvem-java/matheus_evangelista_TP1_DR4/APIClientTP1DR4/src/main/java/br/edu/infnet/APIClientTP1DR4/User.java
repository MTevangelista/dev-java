package br.edu.infnet.APIClientTP1DR4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {   
    @JsonProperty
    private String name;
    @JsonProperty
    private String username;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{name=").append(name);
        sb.append(", username=").append(username);
        sb.append('}');
        return sb.toString();
    }
    
    
}
