package com.infnet.CloudServiceDevJavaATQuotation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infnet.CloudServiceDevJavaATQuotation.model.Quotation;
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
    private String img;
    private String name;
    private int quantity;
    @Column(unique=true)
    private int code;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"product"})
    private Set<Quotation> quotations = new HashSet<>();
    
    public Product() {}

    public Product(
            int id,
            String img,
            String name,
            int quantity,
            int code
    ) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.quantity = quantity;
        this.code = code;
    }
    
    public Product(
            String img,
            String name,
            int quantity,
            int code
    ) {
        this.img = img;
        this.name = name;
        this.quantity = quantity;
        this.code = code;
    }
    
    public Product(
            String img,
            String name,
            int quantity
    ) {
        this.img = img;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
        sb.append(", img=").append(img);
        sb.append(", name=").append(name);
        sb.append(", quantity=").append(quantity);
        sb.append(", code=").append(code);
        sb.append(", quotations=").append(quotations);
        sb.append('}');
        return sb.toString();
    }
}
