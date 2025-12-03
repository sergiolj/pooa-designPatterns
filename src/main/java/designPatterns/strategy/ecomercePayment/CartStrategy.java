package designPatterns.strategy.ecomercePayment;

import java.util.HashMap;
import java.util.Map;

public class CartStrategy {

    private double bill;
    private final Map<String, Double> shoppingList = new HashMap<>();

    public CartStrategy() {}

    public double getBill() {
        return bill;
    }

    public void addItem(String item, double price){
        shoppingList.put(item, price);
        this.bill += price;
    }

    public void removeItem(String item){
        Double removedItemPrice = shoppingList.remove(item); //Usando Double, se o valor for null não resulta em erro.
        if(removedItemPrice != null){
            this.bill -= removedItemPrice;
        }else{
            System.out.println("Item not found");
        }
    }


    public boolean checkout(PaymentStrategy paymentStrategy) {
        if(bill == 0){
            System.out.println("Cart is empty");
            return false;
        }else{
            if(paymentStrategy.pay(this.bill)){
                shoppingList.clear();
                this.bill = 0;
                return true;
            }
        }
        return false;
    }
}
