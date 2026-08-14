package designpatterns.builder.carmodel;

public interface CarBuilderInteface {
    void createEngine(String engine);
    void hasTouchscreen(boolean touchscreen);
    void numberOfDoors(int numberOfDoors);
    Car getCar();
}
