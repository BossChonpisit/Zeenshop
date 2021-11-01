package com.plusitsolution.training.Zeenshop;

public class Historybuying {

    private Product name;
    private Integer amount;
    private Integer price;

    public Historybuying(Product name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Product getName() {
        return name;
    }

    public void setName(Product name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    
    

    
}
