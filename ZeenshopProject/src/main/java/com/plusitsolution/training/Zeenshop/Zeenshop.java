package com.plusitsolution.training.Zeenshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Zeenshop {

    // <productID, Product>
    private static Map<String, Product> PRODUCT_MAP = new HashMap<>();

    // <productID, Buy>
    private static Map<String, Buy> buy_map = new HashMap<>();

    private static int buycount = 0;

    public static void main(String[] args) {

        addProduct(new Product(Productname.MILO, 20, 30)); // ใส่ชื่อสินค้า, ราคา , stock
        addProduct(new Product(Productname.MAGGI, 50, 10)); 
        addProduct(new Product(Productname.NESLE, 30, 5));
        addProduct(new Product(Productname.KOKO, 40, 20));
        listallProduct();
        
        Map<String, Integer> TOBUY_MAP = new HashMap<>();
        TOBUY_MAP.put("P1", 10); // buy(productId, amount)
        TOBUY_MAP.put("P2", 3);

        System.out.println("\n------ Buy this Product ------");
        for (Entry<String, Integer> entry : TOBUY_MAP.entrySet()) {
            buyProduct(entry.getKey(), entry.getValue());
        }
        
        listallProduct();
        historyBuying();
    }

    public static void addProduct(Product product) {
        String productID = "P" + (PRODUCT_MAP.size() + 1);
        PRODUCT_MAP.put(productID, product);
    }


    public static void buyProduct(String productID, int amount) {
        if (amount <= 0) {
            throw new RuntimeException("ใส่จำนวนสินค้าที่ต้องการซื้อให้ถูกต้องด้วยครับ");
        }
        Product product = PRODUCT_MAP.get(productID);
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
        for (Entry<String, Product> entry : PRODUCT_MAP.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Integer calculateFee(Buy buy) {
        Integer fee = 0;
        Product product = PRODUCT_MAP.get(buy.getProductID());
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
        PRODUCT_MAP.put(buy.getProductID(), product);
        fee = fee * buy.getAmount();

        return fee;
    }

    public static void checkbill(String buyID){
        Buy buy = buy_map.get(buyID);
        System.out.println(buy_map.get(buyID).toStringฺBuy(PRODUCT_MAP.get(buy.getProductID()).getName().toString())+", total price : "+calculateFee(buy).toString()+" baht");
    }

    public static void historyBuying(){
        Integer totalPrice = 0;
        System.out.println();
        System.out.println("----- Purchase History ----- ");
        for (Entry<String, Buy> entry : buy_map.entrySet()) {
            Product product = PRODUCT_MAP.get(entry.getValue().getProductID());
            System.out.println(entry.getValue().getProductID()+" "+product.getName().toString()+ 
            " amount "+entry.getValue().getAmount().toString()+" , price : "+ product.getPrice().toString()+" baht per piece");
            totalPrice += (product.getPrice()*entry.getValue().getAmount());
            
        }
        System.out.println("Total price : "+totalPrice+" baht");
    }

}
