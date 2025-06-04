package designPatterns.builder.carModel;

public class Car {
    String engine;
    int numberOfDoors;
    boolean hasTouchscreen;

    Car(){} //package private access

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", numberOfDoors=" + numberOfDoors + ", hasTouchscreen=" + hasTouchscreen + "]";
    }
}
