package designpatterns.behavioral.observer.ecomerceAfterSale;

import designpatterns.behavioral.observer.ecomerceAfterSale.concreteObservers.CustomerNotification;
import designpatterns.behavioral.observer.ecomerceAfterSale.concreteObservers.StockUpdate;
import designpatterns.behavioral.observer.ecomerceAfterSale.model.Customer;
import designpatterns.behavioral.observer.ecomerceAfterSale.model.Order;
import designpatterns.behavioral.observer.ecomerceAfterSale.model.Receipt;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Sérgio", "55-5554294");
        customer.setCommunicationMethod(Customer.CommunicationMethod.WHATSAPP);

        Receipt receipt = new Receipt(customer);
        receipt.addProductToList("TV", 1999);
        receipt.addProductToList("Dishwasher", 999);
        receipt.addProductToList("Three-seater Couch", 500);

        Order order = new Order(receipt);

        order.addObserver(new CustomerNotification());
        order.addObserver(new StockUpdate());

        order.paymentSuccessfulProcessed();
    }
}
