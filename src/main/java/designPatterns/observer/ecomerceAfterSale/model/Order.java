package designPatterns.observer.ecomerceAfterSale.model;

import designPatterns.observer.ecomerceAfterSale.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderObserver> observers;
    private final Receipt receipt;

    public Order(Receipt receipt) {
        observers = new ArrayList<OrderObserver>();
        this.receipt = receipt;
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

    public Receipt getInvoice() {
        return receipt;
    }
}
