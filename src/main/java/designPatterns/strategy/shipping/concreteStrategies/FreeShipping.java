package designPatterns.strategy.shipping.concreteStrategies;

import designPatterns.strategy.shipping.Order;
import designPatterns.strategy.shipping.ShipmentMethodStrategy;

public class FreeShipping implements ShipmentMethodStrategy {
    private final double fixedRate = 10;
    public final String name = "Free";


    @Override
    public double calculateShipment(Order order) {
        if( order.getWeight() <= 3 && order.getPrice() > fixedRate){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public boolean isAvailable(Order order) {
        return order.getWeight() <= 3 && order.getPrice() > fixedRate
                && (order.getCod() == OrderCodes.NATIONAL || order.getCod() == OrderCodes.PICKUP);
    }

    @Override
    public String getName() {
        return this.name;
    }
}

