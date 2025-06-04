package designPatterns.builder.carModel;

public class CarBuilderConcrete implements CarBuilderInteface {
    Car car = new Car();

    @Override
    public void createEngine(String engine) {
        car.engine = engine;
    }

    @Override
    public void hasTouchscreen(boolean touchscreen) {
        car.hasTouchscreen = touchscreen;
    }

    @Override
    public void numberOfDoors(int numberOfDoors) {
        car.numberOfDoors = numberOfDoors;
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
