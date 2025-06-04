package designPatterns.builder;

import java.util.List;

public class PizzaPepperoni implements PizzaBuilderInterface{
    Pizza pizza;

    @Override
    public String makeDough() {
        return "Thin Crust";
    }

    @Override
    public String makeTomatoSauce() {
        return "Italian tomato sauce";
    }

    @Override
    public List<String> addTopping() {
        return List.of("mozzarella","salami","basil","parmesan","drizzle of olive oil");
    }

    @Override
    public Pizza getPizza() {
        return this.pizza;
    }

    @Override
    public boolean withCrust() {
        return false;
    }

    @Override
    public boolean isGlutenFree() {
        return false;
    }
}
