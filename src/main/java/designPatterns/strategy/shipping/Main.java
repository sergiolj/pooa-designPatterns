package designPatterns.strategy.shipping;

import designPatterns.strategy.shipping.concreteStrategies.*;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(100,12, OrderCodes.PICKUP);

        ShipmentMethodStrategy free = new FreeShipping();
        ShipmentMethodStrategy standard = new StandardShipping();
        ShipmentMethodStrategy storePickup = new StorePickup();
        ShipmentMethodStrategy express = new ExpressShipping();

        System.out.println("Choose one of the following shipping methods:\n");

        order.setShipmentMethodStrategy(free);
        if(free.isAvailable(order)){
            System.out.println("Available for Free Shipping Method");
        }else{
            System.out.println("Free shipment not available for this order");
        }

        order.setShipmentMethodStrategy(standard);
        System.out.printf("Standard US$ %.2f\n", standard.calculateShipment(order));

        order.setShipmentMethodStrategy(storePickup);
        if(storePickup.isAvailable(order)){
            System.out.println("Available for Store Pickup Method");
        }else{
            System.out.println("Store pickup not available for this order");
        }

        order.setShipmentMethodStrategy(express);
        if(express.isAvailable(order)){
            System.out.println("Available for Express Method");
            System.out.printf("Express US$ %.2f\n", express.calculateShipment(order));
        }else{
            System.out.println("Express shipment not available for this order");
        }

        System.out.printf("Order total cost US$ %.2f with %s shipping method\n", order.calculateTotalCost(),
                order.getShipmentMethodStrategy().getName());
    }
}
