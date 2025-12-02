package designPatterns.observer.ecomerceAfterSale.concreteObservers;

import designPatterns.observer.ecomerceAfterSale.model.Customer;
import designPatterns.observer.ecomerceAfterSale.model.Order;
import designPatterns.observer.ecomerceAfterSale.OrderObserver;

public class CustomerNotification implements OrderObserver {

    @Override
    public void update(Order order) {
        Customer customer = order.getInvoice().getCustomer();
        Customer.CommunicationMethod method = customer.getCommunicationMethod();
        String phone = customer.getPhone();

        if(method != null){
            switch (method){
                case EMAIL:
                    String emailAddress = customer.getEmail().getAddress();
                    System.out.println("Email notification triggered to " + emailAddress);
                    break;
                case SMS:
                    System.out.println("SMS notification triggered to " + phone);
                    break;
                case WHATSAPP:
                    System.out.println("Whatsapp notification triggered to " + phone);
                    break;
            }
        }else{
            System.out.println("Customer not choose any Communication Method.");
        }
    }
}
