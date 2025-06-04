package designPatterns.builder;

public interface PizzaBuilderInterface {

    PizzaBuilderInterface withDough(String dough);

    PizzaBuilderInterface withSauce(String sauce);

    PizzaBuilderInterface addTopping(String topping);

    PizzaBuilderInterface withCrust(boolean withCrust);

    PizzaBuilderInterface withGlutenFree(boolean withGlutenFree);

    PizzaBuilderInterface stuffedCrustCheese(String cheese);

    Pizza build();
}
