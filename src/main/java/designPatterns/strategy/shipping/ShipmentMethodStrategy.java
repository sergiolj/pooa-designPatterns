package designPatterns.strategy.shipping;

public interface ShipmentMethodStrategy {
    double calculateShipment(Order order);
    boolean isAvailable(Order order);
    String getName();
}
