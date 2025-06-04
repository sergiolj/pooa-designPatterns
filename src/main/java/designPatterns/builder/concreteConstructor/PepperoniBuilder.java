package designPatterns.builder.concreteConstructor;

import designPatterns.builder.Pizza;
import designPatterns.builder.PizzaBuilderInterface;

public class PepperoniBuilder implements PizzaBuilderInterface {

    @Override
    public PizzaBuilderInterface withDough(String dough) {
        return this;
    }

    @Override
    public PizzaBuilderInterface withSauce(String sauce) {
        return this;
    }

    @Override
    public PizzaBuilderInterface addTopping(String topping) {
        return this;
    }

    @Override
    public PizzaBuilderInterface withCrust(boolean withCrust) {
        return this;
    }

    @Override
    public PizzaBuilderInterface withGlutenFree(boolean withGlutenFree) {
        return this;
    }

    @Override
    public PizzaBuilderInterface stuffedCrustCheese(String cheese) {
        return this;
    }

    public Pizza build() {
        Pizza.Builder builder = new Pizza.Builder();
        builder.withSauce("Italian tomato sauce")
                .addTopping("mozzarella")
                .addTopping("salami")
                .addTopping("basil")
                .addTopping("parmesan")
                .addTopping("drizzle of olive oil")
                .withGlutenFree(false);
        return builder.build();
    }
}
