package designPatterns.decorator.coffeeShop;

public class Coffee implements Beverage {


    @Override
    public String description() {
        return "Espresso";
    }

    @Override
    public double price() {
        return 3.0;
    }
}
