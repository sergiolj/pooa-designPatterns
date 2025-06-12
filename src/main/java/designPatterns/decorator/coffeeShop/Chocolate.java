package designPatterns.decorator.coffeeShop;

public class Chocolate extends ExtraDecorator{

    public Chocolate(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + ", chocolate";
    }

    @Override
    public double price() {
        return beverage.price() + 1.0;
    }
}
