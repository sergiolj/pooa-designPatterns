package designPatterns.strategy.shipping.concreteStrategies;

import designPatterns.strategy.shipping.Order;
import designPatterns.strategy.shipping.ShipmentMethodStrategy;

public class StandardShipping implements ShipmentMethodStrategy {
    private final double fixedRate = 10;
    public final String name = "Standard";
    
    @Override
    public double calculateShipment(Order order) {
        if(order.getPrice() > fixedRate) {
            return order.getWeight() * 1.5 + fixedRate;
        }
        return fixedRate;
    }

    @Override
    public boolean isAvailable(Order order) {
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
