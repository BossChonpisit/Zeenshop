package com.plusitsolution.training.Zeenshop;

public class Product {
    private Productname name;
    private Integer price;
    private Integer stock;

    public Product(Productname name, Integer price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Productname getName() {
        return name;
    }

    public void setName(Productname name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String toString() {
        return name + " price " + price + " baht, stock " + stock + " pieces";
    }
}
