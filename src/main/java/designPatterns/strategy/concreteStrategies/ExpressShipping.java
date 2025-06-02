package designPatterns.strategy.concreteStrategies;

import designPatterns.strategy.Order;
import designPatterns.strategy.ShipmentMethodStrategy;

public class ExpressShipping implements ShipmentMethodStrategy {
    private final double fixedRate = 1.5;
    private final String name = "Express";


    @Override
    public double calculateShipment(Order order) {
        return order.getPrice() * fixedRate;
    }

    @Override
    public boolean isAvailable(Order order) {
        return order.getWeight() <=5;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
