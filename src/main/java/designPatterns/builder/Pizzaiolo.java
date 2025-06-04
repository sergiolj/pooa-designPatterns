package designPatterns.builder;

public class Pizzaiolo {

    public Pizza makeStandardPizza(PizzaBuilderInterface builder, String dough, String sauce) {
        builder.withDough(dough)
                .withSauce(sauce)
                .addTopping("Standard Cheese")
                .withGlutenFree(false)
                .withCrust(false);
        return builder.build();
    }

    public Pizza makeSpecialPizza(PizzaBuilderInterface builder) {
        builder.withCrust(true)
                .withDough("Sicilian Crust")
                .stuffedCrustCheese("Cheddar");
        return builder.build();
    }
}
