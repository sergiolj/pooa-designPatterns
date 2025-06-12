package designPatterns.decorator.coffeeShop;

public abstract class ExtraDecorator implements Beverage {
    protected Beverage beverage;

    public ExtraDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String description() {
        return beverage.description();
    }
    @Override
    public double price() {
        return beverage.price();
    }
}
