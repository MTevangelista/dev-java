package com.infnet.CloudServiceDevJavaATProduct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="quotations")
public class Quotation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quotation_id")
    private int id;
    private double price;
    @Column(unique=true)
    private int identifier;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties({"product"})
    private Product product;
    
    public Quotation() {}

    public Quotation(int id, double price, Product product) {
        this.id = id;
        this.price = price;
        this.product = product;
    }
    
    public Quotation(double price, Product product) {
        this.price = price;
        this.product = product;
    }
    
    public Quotation(double price, int identifier, Product product) {
        this.price = price;
        this.identifier = identifier;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quotation{id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", identifier=").append(identifier);
        sb.append(", product=").append(product);
        sb.append('}');
        return sb.toString();
    }
}