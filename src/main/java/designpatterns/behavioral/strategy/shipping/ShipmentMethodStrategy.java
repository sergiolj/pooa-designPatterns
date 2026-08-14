package designpatterns.behavioral.strategy.shipping;

public interface ShipmentMethodStrategy {
    double calculateShipment(Order order);
    boolean isAvailable(Order order);
    String getName();
}
