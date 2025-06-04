package designPatterns.builder.carModel;

public class Main {
    public static void main(String[] args) {
        //Create an object that is a carmaker where each method gives a different feature to the car
        //enabling many configurations other than pre-defined constructors
        CarBuilderConcrete carBuilder = new CarBuilderConcrete();
        carBuilder.numberOfDoors(2);
        carBuilder.createEngine("Rocam 1.0");
        carBuilder.hasTouchscreen(false);

        Car car = carBuilder.getCar();
        System.out.println(car);
    }
}
