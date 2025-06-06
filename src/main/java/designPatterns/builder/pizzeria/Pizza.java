package designPatterns.builder.pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final String dough;
    private final String sauce;
    private String stuffedCrustCheese;
    private List<String> toppings = new ArrayList<>();
    private final boolean hasStuffedCrust;
    private final boolean glutenFree;

    private Pizza(Builder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
        this.hasStuffedCrust = builder.hasStuffedCrust;
        this.stuffedCrustCheese = builder.stuffedCrustCheese;
        this.glutenFree = builder.glutenFree;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public String getDough() {
        return dough;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping=" + toppings +
                ", stuffedCrust=" + hasStuffedCrust +
                ", glutenFree=" + glutenFree +
                '}';
    }

    public Builder toBuild(){
        Builder customBuilder = new Builder();

        customBuilder.withDough(this.dough);
        customBuilder.withSauce(this.sauce);
        customBuilder.withCrust(this.hasStuffedCrust);
        customBuilder.withGlutenFree(this.glutenFree);
        customBuilder.stuffedCrustCheese(this.stuffedCrustCheese);

        for(String topping : this.toppings){
            customBuilder.addTopping(topping);
        }

        return customBuilder;
    }


    public static class Builder implements GenericBuilder {
        private String dough;
        private String sauce;
        private String stuffedCrustCheese;
        private List<String> toppings = new ArrayList<>();
        private boolean hasStuffedCrust;
        private boolean glutenFree;

        public Builder() {
        }

        @Override
        public Builder withDough(String dough) {
            this.dough = dough;
            return this;
        }

        @Override
        public Builder withSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        @Override
        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        @Override
        public Builder withCrust(boolean withCrust) {
            this.hasStuffedCrust = withCrust;
            return this;
        }

        @Override
        public Builder withGlutenFree(boolean withGlutenFree) {
            this.glutenFree = withGlutenFree;
            return this;
        }

        @Override
        public Builder stuffedCrustCheese(String cheese) {
            this.stuffedCrustCheese = cheese;
            return this;
        }

        @Override
        public Pizza build() {
            if (dough == null || sauce == null || toppings == null) {
                throw new IllegalArgumentException("Dough or sauce or crust are required");
            } else {
                return new Pizza(this);
            }
        }
    }
}
