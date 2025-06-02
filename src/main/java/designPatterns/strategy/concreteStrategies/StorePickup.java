package designPatterns.strategy.concreteStrategies;

import designPatterns.strategy.Order;
import designPatterns.strategy.ShipmentMethodStrategy;

public class StorePickup implements ShipmentMethodStrategy {
    public final String name = "Store Pickup";

    @Override
    public double calculateShipment(Order order) {
        return -1;
    }

    @Override
    public boolean isAvailable(Order order) {
        return order.getCod() == OrderCodes.PICKUP;
    }

    public String getName() {
        return this.name;
    }
}
