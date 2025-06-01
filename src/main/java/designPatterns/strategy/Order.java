package designPatterns.strategy;

import designPatterns.strategy.exceptions.ShipmentMethodNotDefined;

public class Order {
    private ShipmentMethodStrategy shipmentMethodStrategy;
    private final double price;
    private final double weight;

    public Order(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    public void setShipmentMethodStrategy(ShipmentMethodStrategy shipmentMethodStrategy) {
        this.shipmentMethodStrategy = shipmentMethodStrategy;
    }

    private double calculateShippingCost() {
        if (shipmentMethodStrategy != null) {
            return this.shipmentMethodStrategy.calculateShipment(this.price, this.weight);
        }else throw new ShipmentMethodNotDefined("Must define a shipping method to calculate shipping price");
    }

    private double calculateTotalCost() {
        if (shipmentMethodStrategy != null) {
            return this.price + shipmentMethodStrategy.calculateShipment(this.price, this.weight);
        }else throw new ShipmentMethodNotDefined("Must define a shipping method to calculate total price");
    }

}
