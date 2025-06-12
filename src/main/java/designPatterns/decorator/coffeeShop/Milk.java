package designPatterns.decorator.coffeeShop;

public class Milk extends ExtraDecorator{

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + ", milk";
    }
    @Override
    public double price() {
        return beverage.price() + 1.0;
    }
}
