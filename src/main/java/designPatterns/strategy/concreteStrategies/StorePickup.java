package designPatterns.strategy.concreteStrategies;

import designPatterns.strategy.ShipmentMethodStrategy;

public class StorePickup implements ShipmentMethodStrategy {

    @Override
    public double calculateShipment(double weight, double value) {
        return 0;
    }
}
