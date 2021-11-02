package com.plusitsolution.training.Zeenshop;

public class Product {
    private Productname name;
    private Integer price;
    private Integer stock;

    public Product(Productname name, Integer price, Integer stock) {
        // for (Productname productname : Productname.values()) {
        //     if (name != productname.name()) {
                
        //     }
        // }
        if (stock <= 0 & stock == null) {
            throw new RuntimeException(" กรอกจำนวน stock ให้ถูกต้อง ");
        }else if (price <= 0 & stock == null) {
            throw new RuntimeException(" กรอกราคาสินค้าให้ถูกต้อง");
        }
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
