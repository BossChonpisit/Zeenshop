package com.plusitsolution.training.Zeenshop;

public class Buy {

    private String productID;
    private Integer amount;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Buy(String productID, Integer amount) {
        this.productID = productID;
        this.amount = amount;
    }

    public String toStringฺBuy(String product) {
        return product + " buy " + amount + " pieces";
    }

}
