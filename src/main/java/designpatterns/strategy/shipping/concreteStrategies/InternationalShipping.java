package designpatterns.strategy.shipping.concreteStrategies;

import designpatterns.strategy.shipping.Order;
import designpatterns.strategy.shipping.ShipmentMethodStrategy;

public class InternationalShipping implements ShipmentMethodStrategy {
    private double fixedRate;
    public final String name = "International";

    @Override
    public double calculateShipment(Order order) {
        return order.getWeight() * fixedRate;
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
