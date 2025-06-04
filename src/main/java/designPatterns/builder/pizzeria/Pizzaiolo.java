package designPatterns.builder.pizzeria;

public class Pizzaiolo { //Director

    public Pizza makeCustomPizza(GenericBuilder builder, String dough, String sauce, boolean crust,
                                 String topping1, String topping2, String topping3) {
        System.out.println("Making a custom pizza...");
        builder.withDough(dough)
                .withSauce(sauce)
                .addTopping(topping1)
                .addTopping(topping2)
                .addTopping(topping3)
                .withGlutenFree(false)
                .withCrust(crust);
        return builder.build();
    }

    public Pizza makeStandardPizza(GenericBuilder builder) {
        System.out.println("Making standard Pizza...");
        builder.withDough("Thin Crust")
                .withSauce("Italian tomato sauce")
                .withGlutenFree(false)
                .withCrust(false);
        return builder.build();
    }

    public Pizza makeSimplePizza(GenericBuilder builder) {
        System.out.println("Making simple Pizza...");
        builder.withDough("Thin Crust")
                .withSauce("Italian tomato sauce")
                .addTopping("Mussarela Cheese")
                .withGlutenFree(false)
                .withCrust(false);
        return builder.build();
    }


    public Pizza makeSpecialPizza(GenericBuilder builder) {
        System.out.println("Making special Pizza...");
        builder.withCrust(true)
                .withDough("Sicilian Crust")
                .stuffedCrustCheese("Cheddar");
        return builder.build();
    }

    public Pizza makeMargherita(GenericBuilder builder) {
        System.out.println("Making special Pizza...");
        builder.withCrust(true)
                .withDough("Sicilian Crust")
                .stuffedCrustCheese("Cheddar");
        return builder.build();
    }
}
