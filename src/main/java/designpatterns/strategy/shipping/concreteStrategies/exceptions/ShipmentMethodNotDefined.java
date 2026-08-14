package designpatterns.strategy.shipping.concreteStrategies.exceptions;

public class ShipmentMethodNotDefined extends RuntimeException {
    public ShipmentMethodNotDefined(String message) {
        super(message);
    }
}
