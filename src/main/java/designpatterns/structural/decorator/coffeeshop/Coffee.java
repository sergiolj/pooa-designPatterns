package designpatterns.structural.decorator.coffeeshop;

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
