package designPatterns.strategy;

import designPatterns.strategy.concreteStrategies.OrderCodes;
import designPatterns.strategy.exceptions.ShipmentMethodNotDefined;

public class Order {
    private ShipmentMethodStrategy shipmentMethodStrategy;
    private final double price;
    private final double weight;
    private final OrderCodes cod;

    public Order(double price, double weight, OrderCodes cod) {
        this.price = price;
        this.weight = weight;
        this.cod = cod;
    }

    public void setShipmentMethodStrategy(ShipmentMethodStrategy methodStrategy) {
        this.shipmentMethodStrategy = methodStrategy;
    }

    public double calculateTotalCost() {
        if (shipmentMethodStrategy != null) {
            return this.price + shipmentMethodStrategy.calculateShipment(this);
        }else throw new ShipmentMethodNotDefined("Must define a shipping method to calculate total price");
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public ShipmentMethodStrategy getShipmentMethodStrategy() {
        return shipmentMethodStrategy;
    }
    public OrderCodes getCod() {
        return cod;
    }
}
