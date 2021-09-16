package br.edu.infnet.springmvc.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    private String name;
    @Column(unique=true)
    private String email;
    private String phone;
    private String cep;
    private String address;

    public User() {
    }

    public User(String name, String email, String phone, String cep, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cep = cep;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int idperson) {
        this.id = idperson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", phone=" + phone + ", cep=" + cep + ", address=" + address + '}';
    }
    
}
