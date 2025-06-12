package designPatterns.decorator.coffeeShop;

public class Cinnamon extends ExtraDecorator {

    public Cinnamon(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double price() {
        return beverage.price() + 0.50;
    }
    @Override
    public String description() {
        return beverage.description() + ", cinnamon";
    }
}
