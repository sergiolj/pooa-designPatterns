package designPatterns.strategy.concreteStrategies;

import designPatterns.strategy.ShipmentMethodStrategy;

public class InternationalShipping implements ShipmentMethodStrategy {
    private double fixedRate;

    @Override
    public double calculateShipment(double weight, double value) {
        return weight * fixedRate;
    }
}
