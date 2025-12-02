package designPatterns.observer.ecomerceAfterSale;

import designPatterns.observer.ecomerceAfterSale.concreteObservers.CustomerNotification;
import designPatterns.observer.ecomerceAfterSale.concreteObservers.StockUpdate;
import designPatterns.observer.ecomerceAfterSale.model.Customer;
import designPatterns.observer.ecomerceAfterSale.model.Invoice;
import designPatterns.observer.ecomerceAfterSale.model.Order;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Sérgio", "55-5554294");
        customer.setCommunicationMethod(Customer.CommunicationMethod.WHATSAPP);

        Invoice invoice = new Invoice(customer);
        invoice.addProductToList("TV", 1999);
        invoice.addProductToList("Dishwasher", 999);
        invoice.addProductToList("Three-seater Couch", 500);

        Order order = new Order(invoice);

        order.addObserver(new CustomerNotification());
        order.addObserver(new StockUpdate());

        order.paymentSuccessfulProcessed();
    }
}
