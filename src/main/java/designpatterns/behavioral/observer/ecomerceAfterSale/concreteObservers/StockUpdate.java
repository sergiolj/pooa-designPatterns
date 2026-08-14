package designpatterns.behavioral.observer.ecomerceAfterSale.concreteObservers;

import java.util.ArrayList;
import java.util.List;

import designpatterns.behavioral.observer.ecomerceAfterSale.OrderObserver;
import designpatterns.behavioral.observer.ecomerceAfterSale.model.Order;
import designpatterns.behavioral.observer.ecomerceAfterSale.model.Receipt;

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
