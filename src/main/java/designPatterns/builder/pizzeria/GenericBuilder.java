package designPatterns.builder.pizzeria;

public interface GenericBuilder {

    GenericBuilder withDough(String dough);

    GenericBuilder withSauce(String sauce);

    GenericBuilder addTopping(String topping);

    GenericBuilder withCrust(boolean withCrust);

    GenericBuilder withGlutenFree(boolean withGlutenFree);

    GenericBuilder stuffedCrustCheese(String cheese);

    Pizza build();
}
