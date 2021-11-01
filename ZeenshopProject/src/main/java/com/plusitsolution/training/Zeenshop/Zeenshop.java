package com.plusitsolution.training.Zeenshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Zeenshop {

    // <productID, Product>
    private static Map<String, Product> product_map = new HashMap<>();

    // <productID, Buy>
    private static Map<String, Buy> buy_map = new HashMap<>();


    private static int buycount = 0;

    public static void main(String[] args) {

        addProduct(new Product(Productname.MILO, 20, 30));
        addProduct(new Product(Productname.MAGGI, 50, 10));
        addProduct(new Product(Productname.NESLE, 30, 5));
        addProduct(new Product(Productname.KOKO, 40, 20));
        listallProduct();

        Map<String, Integer> toBuyMap = new HashMap<>();
        toBuyMap.put("P1", 10);
        toBuyMap.put("P2", 5);

        for (Entry<String, Integer> entry : toBuyMap.entrySet()) {
            buyProduct(entry.getKey(), entry.getValue());
        }
        
        listallProduct();
        historyBuying();
    }

    public static String addProduct(Product product) {
        String productID = "P" + (product_map.size() + 1);
        product_map.put(productID, product);
        return productID;
    }


    public static void buyProduct(String productID, int amount) {
        if (amount == 0) {
            throw new RuntimeException("ใส่จำนวนสินค้าที่ต้องการซื้อด้วยครับ");
        }
        Product product = product_map.get(productID);
        if (product == null) {
            throw new RuntimeException(productID + " : ไม่พบสินค้าที่ท่านต้องการ");
        }
        Buy buy = new Buy(productID, amount);
        String buyID = "B" + ++buycount;
        buy_map.put(buyID, buy);
        checkbill(buyID);
    }

    public static void listallProduct() {
        System.out.println();
        System.out.println("------ All of the Product in stock ------");
        for (Entry<String, Product> entry : product_map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Integer calculateFee(Buy buy) {
        Integer fee = 0;
        Product product = product_map.get(buy.getProductID());
        int stock = product.getStock();
        int amount = buy.getAmount();
        if (stock < amount) {
            throw new RuntimeException("ไม่สามารถซื้อสินค้าจำนวนเท่านี้ได้");
        }
        switch (product.getName()) {
        case MILO:
            fee += 20;
            break;
        case MAGGI:
            fee += 50;
            break;
        case NESLE:
            fee += 30;
            break;
        case KOKO:
            fee += 40;
            break;
        default:
            break;
        }
        stock -= amount;
        product.setStock(stock);
        product_map.put(buy.getProductID(), product);
        fee = fee * buy.getAmount();

        return fee;
    }

    public static void checkbill(String buyID){
        Buy buy = buy_map.get(buyID);
        System.out.println(buy_map.get(buyID).toString(product_map.get(buy.getProductID()).getName().toString())+" total price : "+calculateFee(buy).toString());
        
    }

    public static void historyBuying(){
        Integer totalPrice = 0;
        System.out.println();
        System.out.println("----- Purchase History ----- ");
        for (Entry<String, Buy> entry : buy_map.entrySet()) {
            Product product = product_map.get(entry.getValue().getProductID());
            System.out.println(entry.getValue().getProductID()+" "+product.getName().toString()+ 
            " amount "+entry.getValue().getAmount().toString()+" price "+ product.getPrice().toString());
            totalPrice += product.getPrice();
        }
        System.out.println("Total price : "+totalPrice);
    }

}
