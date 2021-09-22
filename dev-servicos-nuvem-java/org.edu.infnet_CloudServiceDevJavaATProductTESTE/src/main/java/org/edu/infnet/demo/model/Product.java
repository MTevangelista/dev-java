package org.edu.infnet.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    private String name;
    private int quantity;
    @Column(unique=true)
    private int code;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Quotation> quotations = new HashSet<>();
    
    public Product() {}

    public Product(int id, String name, int quantity, int code) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.code = code;
    }
    
    public Product(String name, int quantity, int code) {
        this.name = name;
        this.quantity = quantity;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Set<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(Set<Quotation> quotations) {
        this.quotations = quotations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", quantity=").append(quantity);
        sb.append(", code=").append(code);
        sb.append(", quotations=").append(quotations);
        sb.append('}');
        return sb.toString();
    }
}
