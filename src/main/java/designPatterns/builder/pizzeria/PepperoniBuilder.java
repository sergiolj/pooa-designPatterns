package designPatterns.builder.pizzeria;

import java.util.ArrayList;
import java.util.List;

public class PepperoniBuilder implements GenericBuilder {
    private String dough;
    private String sauce;
    private String stuffedCrustCheese;
    private List<String> toppings;
    private boolean stuffedCrust;
    private boolean glutenFree;
    
    public PepperoniBuilder() {
        this.dough = "Thin Crust";
        this.sauce = "Italian tomato sauce";
        this.toppings =  new ArrayList<>
                (List.of("mozzarella","pepperoni", "basil", "parmesan","drizzle of olive oil" ));
        this.stuffedCrust = false;
        this.stuffedCrustCheese = "none";
        this.glutenFree = false;
    }
    
    @Override
    public GenericBuilder withDough(String dough) {
        this.dough = dough;
        return this;
    }

    @Override
    public GenericBuilder withSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    @Override
    public GenericBuilder addTopping(String topping) {
        this.toppings.add(topping);
        return this;
    }

    @Override
    public GenericBuilder withCrust(boolean withCrust) {
        this.stuffedCrust = withCrust;
        return this;
    }

    @Override
    public GenericBuilder withGlutenFree(boolean withGlutenFree) {
        this.glutenFree = withGlutenFree;
        return this;
    }

    @Override
    public GenericBuilder stuffedCrustCheese(String cheese) {
        if (this.stuffedCrust) {
            this.stuffedCrustCheese = cheese;
        }else{
            throw new IllegalArgumentException("Choose stuffed crust option first.");
        }
        return this;
    }

    @Override
    public Pizza build() {
        Pizza.Builder builder = new Pizza.Builder();
        builder.withDough(this.dough)
                .withSauce(this.sauce)
                .withGlutenFree(this.glutenFree)
                .withCrust(this.stuffedCrust)
                .stuffedCrustCheese(this.stuffedCrustCheese);
        
        for(String topping : this.toppings){
            builder.addTopping(topping);
        }

        return builder.build();
    }
}
