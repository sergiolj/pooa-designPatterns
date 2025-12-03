package designPatterns.observer.ecomerceAfterSale.concreteObservers;

import designPatterns.observer.ecomerceAfterSale.model.Receipt;
import designPatterns.observer.ecomerceAfterSale.model.Order;
import designPatterns.observer.ecomerceAfterSale.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class StockUpdate implements OrderObserver {

    @Override
    public void update(Order order) {
        Receipt receipt = order.getInvoice();
        List<String> products = new ArrayList<>(receipt.getProductList().keySet());
        for(String product : products){
            System.out.println("Remove item " + product + " from stock Database");
        }
    }
}
