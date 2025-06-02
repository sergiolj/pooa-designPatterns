package designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    private final String dough;
    private final String sauce;
    private final List<String> topping = new ArrayList<>();
    private boolean stuffedCrust;
    private boolean glutenFree;

    private Pizza (PizzaBuilder pizzaBuilder) {
        this.glutenFree = pizzaBuilder.glutenFree;
        this.dough = pizzaBuilder.makeDough()

}
public static class PizzaBuilder {
    private String dough;
    private String sauce;
    private final List<String> topping = new ArrayList<>();
    private boolean stuffedCrust;
    private boolean glutenFree;

    public PizzaBuilder(String dough, String sauce) {
        if(dough == null || dough.isEmpty() || sauce == null || sauce.isEmpty()) {
            throw new IllegalArgumentException("Dough or sauce can't be null or empty");
        }
        this.dough = dough;
        this.sauce = sauce;
    }

    public PizzaBuilder makeDough(String dough) {
        if(dough == null || dough.isEmpty()) {
            throw new IllegalArgumentException("Dough can't be null or empty");
        }
        this.dough = dough;
        return this;
    }



}

}
