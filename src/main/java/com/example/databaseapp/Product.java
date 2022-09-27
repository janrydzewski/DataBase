package com.example.databaseapp;

import javafx.beans.property.SimpleStringProperty;

public class Product {
    private SimpleStringProperty id, product, price;

    public Product(String id, String product, String price) {
        this.id = new SimpleStringProperty(id);
        this.product = new SimpleStringProperty(product);
        this.price = new SimpleStringProperty(price);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getProduct() {
        return product.get();
    }

    public SimpleStringProperty productProperty() {
        return product;
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
