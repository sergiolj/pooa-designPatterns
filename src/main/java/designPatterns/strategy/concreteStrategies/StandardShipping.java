package designPatterns.strategy.concreteStrategies;

import designPatterns.strategy.ShipmentMethodStrategy;

public class StandardShipping implements ShipmentMethodStrategy {
    private final double fixedRate = 10;
    
    @Override
    public double calculateShipment(double weight, double value) {
        if(value > fixedRate) {
            return weight * 1.5;
        }
        return weight * 1.5 + fixedRate;
    }
}
