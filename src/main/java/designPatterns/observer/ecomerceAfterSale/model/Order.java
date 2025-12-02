package designPatterns.observer.ecomerceAfterSale.model;

import designPatterns.observer.ecomerceAfterSale.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderObserver> observers;
    private final Invoice invoice;

    public Order(Invoice invoice) {
        observers = new ArrayList<OrderObserver>();
        this.invoice =  invoice;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void paymentSuccessfulProcessed() {
        notifyObservers();
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
