package designPatterns.strategy.exceptions;

public class ShipmentMethodNotDefined extends RuntimeException {
    public ShipmentMethodNotDefined(String message) {
        super(message);
    }
}
