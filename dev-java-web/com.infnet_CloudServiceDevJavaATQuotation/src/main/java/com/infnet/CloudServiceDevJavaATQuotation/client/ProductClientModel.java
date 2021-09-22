package com.infnet.CloudServiceDevJavaATQuotation.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductClientModel{
    @JsonProperty
    private int id;
    @JsonProperty
    private String img;
    @JsonProperty
    private String name;
    @JsonProperty
    private int quantity;
    @JsonProperty
    private int code;
    
    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{id=").append(id);
        sb.append(", img=").append(img);
        sb.append(", name=").append(name);
        sb.append(", quantity=").append(quantity);
        sb.append(", code=").append(code);
        sb.append('}');
        return sb.toString();
    }
}
