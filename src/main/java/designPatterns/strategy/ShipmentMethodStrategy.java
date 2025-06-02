package designPatterns.strategy;

public interface ShipmentMethodStrategy {
    double calculateShipment(Order order);
    boolean isAvailable(Order order);
    String getName();
}
