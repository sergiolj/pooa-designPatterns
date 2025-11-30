package designPatterns.strategy.shipping.concreteStrategies;

import designPatterns.strategy.shipping.Order;
import designPatterns.strategy.shipping.ShipmentMethodStrategy;

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
